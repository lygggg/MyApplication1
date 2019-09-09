package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chickenmenu.*

class ChickenMenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chickenmenu)

        btn_chicken_huride.setOnClickListener {
            val intent = Intent(this, HurideActivity::class.java)
            startActivity(intent)
        }
        btn_chicken_spicy.setOnClickListener {
            val intent = Intent(this, SpicyActivity::class.java)
            startActivity(intent)
        }
        btn_chicken_ganjang.setOnClickListener {
            val intent = Intent(this, GanjangActivity::class.java)
            startActivity(intent)
        }
        btn_chicken_goldolive.setOnClickListener {
            val intent = Intent(this, GoldoliveActivity::class.java)
            startActivity(intent)
        }
        btn_chicken_bburingcle.setOnClickListener {
            val intent = Intent(this, BburingcleActivity::class.java)
            startActivity(intent)
        }

    }
}