package `in`.udip.astitva.ui.form

import `in`.udip.astitva.R
import `in`.udip.astitva.databinding.FragmentAgeQuestionBinding
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.method.CharacterPickerDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import android.icu.util.Calendar

class AgeQuestionFragment: Fragment() {

    private var _binding: FragmentAgeQuestionBinding? = null
    val binding get() = _binding!!

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var dateButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAgeQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn = binding.formNextButton
        nextBtn.setOnClickListener { onNext() }

        val backBtn = binding.formBackButton
        backBtn.setOnClickListener { onBack() }

        initDatePicker()
        dateButton = binding.datePicker
        dateButton.setOnClickListener { openDatePicker() }
        dateButton.setText(getTodaysDate())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNext() {
        val args: Bundle = requireArguments()
        args.putString("dob", dateButton.text.toString())

        val frag: DisabilityQuestionFragment = DisabilityQuestionFragment()
        frag.arguments = args

        val txn = parentFragmentManager.beginTransaction()
        txn.replace(R.id.form_question, frag)
        txn.addToBackStack(null)
        txn.commit()
    }

    private fun onBack() {
        val txn = parentFragmentManager.beginTransaction()
        txn.replace(R.id.form_question, NameQuestionFragment())
        txn.commit()
    }

    private fun initDatePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                val date: String = makeDateString(day, month + 1, year)
                dateButton.text = date
        }

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val style = AlertDialog.THEME_HOLO_LIGHT

        datePickerDialog = DatePickerDialog(requireContext(), style, dateSetListener, year, month, day)
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return day.toString() + " " + getMonthFormat(month) + " " + year.toString()
    }

    private fun getMonthFormat(month: Int): String {
        return when(month) {
            1 -> "JAN"
            2 -> "FEB"
            3 -> "MAR"
            4 -> "APR"
            5 -> "MAY"
            6 -> "JUN"
            7 -> "JUL"
            8 -> "AUG"
            9 -> "SEP"
            10 -> "OCT"
            11 -> "NOV"
            else -> "DEC"
        }
    }

    private fun openDatePicker() {
        datePickerDialog.show()
    }

    private fun getTodaysDate(): String {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DAY_OF_MONTH)
        return makeDateString(day, month, year)
    }
}