package `in`.udip.astitva.ui.form

import `in`.udip.astitva.databinding.FragmentAgeQuestionBinding
import `in`.udip.astitva.databinding.FragmentDisabilityIdQuestionBinding
import `in`.udip.astitva.databinding.FragmentDisabilityQuestionBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DisabilityIdQuestionFragment: Fragment() {

    private var _binding: FragmentDisabilityIdQuestionBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisabilityIdQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}