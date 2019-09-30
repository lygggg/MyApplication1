package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.chinafoodmenu.*

class ChinafoodMenuActivity : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.chinafoodmenu)
            btn_chinafood_zzazang.setOnClickListener {
                val intent = Intent(this, ZzazangActivivy::class.java)
                startActivity(intent)
                finish()
            }


        }
}