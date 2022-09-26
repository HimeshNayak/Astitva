package `in`.udip.astitva.ui.account

import `in`.udip.astitva.databinding.FragmentAccountBinding
import `in`.udip.astitva.ui.form.DBHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val accountViewModel =
//            ViewModelProvider(this).get(AccountViewModel::class.java)

        _binding = FragmentAccountBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DBHelper(requireContext(), null)
        val cursor = db.getName()

        cursor!!.moveToFirst()
        binding.disabilityIdTextView.text = cursor.getString(0)
        binding.nameTextView.text = cursor.getString(1)
        binding.ageTextView.text = cursor.getString(2)
        binding.disabilityTextView.text = cursor.getString(3)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}