package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.joinn.*

class joinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.joinn)
        finish_task.setOnClickListener {




            val idintent = Intent(this, MyyogiyoActivity::class.java)
            idintent.putExtra("idTitle", make_Id.text.toString())
            startActivity(idintent)
            idintent.putExtra("nameTitle",make_Name.text.toString())
            startActivity(idintent)
            finish()
        }

        Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        // The activity is about to become visible.
    }

    override fun onResume() {
        super.onResume()
        // The activity has become visible (it is now "resumed").

    }

    override fun onPause() {
        super.onPause()
        // Another activity is taking focus (this activity is about to be "paused").
    }

    override fun onStop() {
        super.onStop()
        // The activity is no longer visible (it is now "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        // The activity is about to be destroyed.
        Toast.makeText(this, "안녕히 가세요", Toast.LENGTH_SHORT).show()
    }
}
