package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.joinn.*

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.joinn)

        finish_task.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
            val message = dialogView.findViewById<TextView>(R.id.message)
            message.text = "회원가입중입니다..."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog = builder.create()
            dialog.show()
            Handler().postDelayed({

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            },2000)
        }

        Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show()
    }

}
