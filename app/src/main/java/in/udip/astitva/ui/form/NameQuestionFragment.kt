package `in`.udip.astitva.ui.form

import `in`.udip.astitva.R
import `in`.udip.astitva.databinding.FragmentNameQuestionBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.util.regex.Pattern

class NameQuestionFragment: Fragment() {

    private var _binding: FragmentNameQuestionBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameQuestionBinding.inflate(inflater, container, false)
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
        if (binding.firstNameEditText.text.toString() == "" ||
            !Pattern.matches("^[A-Za-z][A-Za-z ]+$", binding.firstNameEditText.text.toString())) {
            binding.textField.isErrorEnabled = true
            binding.textField.error =resources.getString(R.string.invalid_name)
        }
        else {
            binding.textField.isErrorEnabled = false

            val args: Bundle = requireArguments()
            args.putString("name", binding.firstNameEditText.text.toString())

            val frag: AgeQuestionFragment = AgeQuestionFragment()
            frag.arguments = args

            val txn = parentFragmentManager.beginTransaction()
            txn.replace(R.id.form_question, frag)
            txn.addToBackStack(null)
            txn.commit()
        }
    }

    private fun onBack() {
        val txn = parentFragmentManager.beginTransaction()
        txn.replace(R.id.form_question, DisabilityIdQuestionFragment())
        txn.commit()
    }
}