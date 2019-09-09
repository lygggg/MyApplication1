package edu.dongyang.cs.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_search.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        btn_main_buylist.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        btn_main_myyogiyo.setOnClickListener {
            val intent = Intent(this, MyyogiyoActivity::class.java)
            startActivity(intent)
        }
        btn_main_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btn_main_pizza.setOnClickListener {
            val intent = Intent(this, PizzamenuActivity::class.java)
            startActivity(intent)
        }
        btn_main_chinafood.setOnClickListener {
            val intent = Intent(this, ChinafoodMenuActivity::class.java)
            startActivity(intent)
        }
        btn_main_chicken.setOnClickListener {
            val intent = Intent(this, ChickenMenuActivity::class.java)
            startActivity(intent)
        }
        btn_main_bunsik.setOnClickListener {
            val intent = Intent(this, BunsikMenuActivity::class.java)
            startActivity(intent)
        }
        btn_main_hansik.setOnClickListener {
            val intent = Intent(this, YasikMenuMenuActivity::class.java)
            startActivity(intent)
        }
        btn_main_jokbal.setOnClickListener {
            val intent = Intent(this, YasikMenuMenuActivity::class.java)
            startActivity(intent)
        }

        btn_main_sushi.setOnClickListener {
            val intent = Intent(this, SushiMenuMenuActivity::class.java)
            startActivity(intent)

        }


    }
}
