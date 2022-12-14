package `in`.udip.astitva

import `in`.udip.astitva.ui.form.DBHelper
import `in`.udip.astitva.ui.form.FormActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val db = DBHelper(this, null)
        val cursor = db.getName()

        if (!(cursor != null && cursor.moveToFirst())) {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@MainActivity, FormActivity::class.java)
                startActivity(intent)
                finish()
            }, 2500)
        }
        else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }, 2500)
        }
    }
}