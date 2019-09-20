package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.myyogiyo.*

class MyyogiyoActivity : AppCompatActivity(){
    lateinit var idTitle : String
    lateinit var nameTitle : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myyogiyo)
        if(intent.hasExtra("idTitle")){
            idTitle = intent.getStringExtra("idTitle").toString()
            et_id_title.setText(idTitle)
        }
        if(intent.hasExtra("nameTitle")){
            nameTitle = intent.getStringExtra("nameTitle").toString()
            et_name_title.setText(nameTitle)
        }
        btn_myyogiyo_payment.setOnClickListener {
            val intent = Intent(this, MembershipActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_myyogiyo_guide.setOnClickListener {
            val intent = Intent(this, GuideActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_myyogiyo_center.setOnClickListener {
            val intent = Intent(this, UsercenterActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_login.setOnClickListener {
            val intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}