package `in`.udip.astitva.ui.form

import `in`.udip.astitva.HomeActivity
import `in`.udip.astitva.databinding.ActivityFormBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class FormActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.questionRecyclerView
        recyclerView.adapter = FormAdapter(this)

        val formNextButton = binding.formNextButton
        formNextButton.setOnClickListener{
            val intent = Intent(this@FormActivity, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}