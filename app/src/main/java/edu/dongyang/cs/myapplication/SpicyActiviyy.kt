package edu.dongyang.cs.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.buybburingcle.*
import kotlinx.android.synthetic.main.buybburingcle.plus_colla
import kotlinx.android.synthetic.main.buybburingcle.plus_dellisauce
import kotlinx.android.synthetic.main.buybburingcle.plus_mayosauce
import kotlinx.android.synthetic.main.buybburingcle.plus_mu
import kotlinx.android.synthetic.main.buybburingcle.plus_potato
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.buyspicy.*

class SpicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buyspicy)

        var price: Int = 15000
        plus_colla.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_colla.isChecked == true) {
                price += 2000
                spicy_price.text = "가격: "+price
            } else
                price -= 2000
            spicy_price.text = "가격: "+price



        }
        plus_dellisauce.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_dellisauce.isChecked == true) {
                price += 500
                spicy_price.text = "가격: "+price
            } else
                price -= 500
            spicy_price.text = "가격: "+price



        }
        plus_mayosauce.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_mayosauce.isChecked == true) {
                price += 500
                spicy_price.text = "가격: "+price
            } else
                price -= 500
            spicy_price.text = "가격: "+price



        }
        plus_mu.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_mu.isChecked == true) {
                price += 500
                spicy_price.text = "가격: "+price
            } else
                price -= 500
            spicy_price.text = "가격: "+price



        }
        plus_potato.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_potato.isChecked == true) {
                price += 2500
                spicy_price.text = "가격: "+price
            } else
                price -= 2500
            spicy_price.text = "가격: "+price



        }




    }
}