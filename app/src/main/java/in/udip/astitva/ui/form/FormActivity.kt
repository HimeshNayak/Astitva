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
        supportActionBar?.hide()
        Log.d("FormActivity", "Form Activity started")

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("FormActivity", "Layout inflated")

        val questionFragment = supportFragmentManager
            .findFragmentById(R.id.form_question) as NavHostFragment
        navController = questionFragment.navController
        Log.d("FormActivity", "NavController initialized")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}