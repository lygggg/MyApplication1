package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.myyogiyo.*

class MyyogiyoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myyogiyo)

        btn_myyogiyo_payment.setOnClickListener {
            val intent = Intent(this, MembershipActivity::class.java)
            startActivity(intent)
        }

        btn_myyogiyo_guide.setOnClickListener {
            val intent = Intent(this, GuideActivity::class.java)
            startActivity(intent)
        }
        btn_myyogiyo_center.setOnClickListener {
            val intent = Intent(this, UsercenterActivity::class.java)
            startActivity(intent)
        }

    }
}