package `in`.udip.astitva.ui.form

import `in`.udip.astitva.R
import `in`.udip.astitva.HomeActivity
import `in`.udip.astitva.databinding.ActivityFormBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class FormActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    private lateinit var navController: NavController
    private var questionNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("FormActivity", "Form Activity started")

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("FormActivity", "Layount inflated")

        val questionFragment = supportFragmentManager
            .findFragmentById(R.id.form_question) as NavHostFragment
        navController = questionFragment.navController
        Log.d("FormActivity", "NavController initialized")

        val nextBtn = binding.formNextButton
        nextBtn.setOnClickListener{ onNext(binding.formQuestion) }

        val prevBtn = binding.formBackButton
        prevBtn.setOnClickListener { onPrev(binding.formQuestion) }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun onNext(view: View) {
        when (questionNumber) {
            1 -> {
                view.findNavController().navigate(
                    R.id.action_nameQuestionFragment_to_ageQuestionFragment)
                questionNumber++ }
            2 -> {
                view.findNavController().navigate(
                    R.id.action_ageQuestionFragment_to_disabilityQuestionFragment)
                questionNumber++ }
        }
    }

    private fun onPrev(view: View) {
        when( questionNumber) {
            2 -> {
                view.findNavController().navigate(
                    R.id.action_ageQuestionFragment_to_nameQuestionFragment)
                questionNumber-- }
            3 -> {
                view.findNavController().navigate(
                    R.id.action_disabilityQuestionFragment_to_ageQuestionFragment)
                questionNumber-- }
        }
        val recyclerView: RecyclerView = binding.questionRecyclerView
        recyclerView.adapter = FormAdapter(this)

        val formNextButton = binding.formNextButton
        formNextButton.setOnClickListener{
            val intent = Intent(this@FormActivity, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}