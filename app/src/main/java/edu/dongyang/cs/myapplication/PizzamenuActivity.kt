package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.chickenmenu.*
import kotlinx.android.synthetic.main.pizzamenu.*

class PizzamenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pizzamenu)
        btn_pizza_combination.setOnClickListener {
            val intent = Intent(this, PizzaCombnationActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_pizza_goguma.setOnClickListener {
            val intent = Intent(this, PizzaGogumaActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_pizza_cheeze.setOnClickListener {
            val intent = Intent(this, PizzaCheezeActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_pizza_potato.setOnClickListener {
            val intent = Intent(this, PizzaPotatoActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_pizza_bulgogi.setOnClickListener {
            val intent = Intent(this, PizzaBulgogiActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}