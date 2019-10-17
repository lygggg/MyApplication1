package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.usercenter.*

class UsercenterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.usercenter)
        btn_chat.setOnClickListener {
            startActivity(Intent(this,ChatRoomActivity::class.java))
        }


    }
}