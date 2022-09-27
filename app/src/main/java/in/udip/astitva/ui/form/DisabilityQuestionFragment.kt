package `in`.udip.astitva.ui.form

import `in`.udip.astitva.HomeActivity
import `in`.udip.astitva.R
import `in`.udip.astitva.databinding.FragmentDisabilityQuestionBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DisabilityQuestionFragment: Fragment() {

    private var _binding: FragmentDisabilityQuestionBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisabilityQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn = binding.formNextButton
        nextBtn.setOnClickListener { onNext() }

        val backBtn = binding.formBackButton
        backBtn.setOnClickListener { onBack() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNext() {
        var disability = ""
        if (binding.visuallyImpaired.isChecked)
            disability += getString(R.string.visually_impaired) + ", "
        if (binding.hearingImpaired.isChecked)
            disability += getString(R.string.hearing_impaired) + ", "
        if (binding.physicalHandicap.isChecked)
            disability += getString(R.string.physical_handicap) + ", "
        if (binding.cerebralPalsy.isChecked)
            disability += getString(R.string.cerebral_palsy)

        val args: Bundle = requireArguments()
        args.putString("disability", disability)

        Log.d("DBH", "Going to open DBHelper")
        val db = DBHelper(requireContext(), null)
        db.addName(
            args.getString("disabilityId")!!,
            args.getString("name")!!,
            args.getString("dob")!!,
            args.getString("disability")!!
        )
        Log.d("DBH", "Added data")

        val ctx = activity
        val intent = Intent(ctx, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun onBack() {
        val txn = parentFragmentManager.beginTransaction()
        txn.replace(R.id.form_question, AgeQuestionFragment())
        txn.commit()
    }
}