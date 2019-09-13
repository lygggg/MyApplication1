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
            }
            btn_chinafood_bokumbab.setOnClickListener {
                val intent = Intent(this, BokumbabActivity::class.java)
                startActivity(intent)
            }
            btn_chinafood_tangsu.setOnClickListener {
                val intent = Intent(this, TangsuActivity::class.java)
                startActivity(intent)
            }
            btn_chinafood_falbochae.setOnClickListener {
                val intent = Intent(this, FalbochaeActivity::class.java)
                startActivity(intent)
            }
            btn_chinafood_jabchae.setOnClickListener {
                val intent = Intent(this, JabchaeActivity::class.java)
                startActivity(intent)
            }

        }
}