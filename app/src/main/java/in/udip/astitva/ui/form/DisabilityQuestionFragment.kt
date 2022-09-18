package `in`.udip.astitva.ui.form

import `in`.udip.astitva.HomeActivity
import `in`.udip.astitva.R
import `in`.udip.astitva.databinding.FragmentDisabilityQuestionBinding
import android.content.Intent
import android.os.Bundle
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