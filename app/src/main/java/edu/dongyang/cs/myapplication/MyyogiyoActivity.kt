package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.myyogiyo.*

class MyyogiyoActivity : AppCompatActivity(){
    private val pref by lazy {
        this.getPreferences(0)
    }
    private val editor by lazy {
        pref.edit()
    }

    lateinit var idTitle : String
    lateinit var nameTitle : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myyogiyo)
        if(intent.hasExtra("idTitle")){
            idTitle = intent.getStringExtra("idTitle").toString()
            editor.putString("playerId",idTitle).apply()
        }
        et_id_title.setText(pref.getString("playerId","로그인을 해주세요"))
        if(intent.hasExtra("nameTitle")){
            nameTitle = intent.getStringExtra("nameTitle").toString()
            editor.putString("playerName",nameTitle).apply()
        }
        et_name_title.setText(pref.getString("playerName",""))
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
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this,"로그아웃했습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}