package edu.dongyang.cs.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bulgogipizza.*
import kotlinx.android.synthetic.main.bulgogipizza.pizza_plus_colla
import kotlinx.android.synthetic.main.bulgogipizza.pizza_plus_hotsource
import kotlinx.android.synthetic.main.bulgogipizza.pizza_plus_spageti
import kotlinx.android.synthetic.main.bulgogipizza.plus_pizza_plus_cheeze
import kotlinx.android.synthetic.main.bulgogipizza.plus_pizza_plus_chlisource
import kotlinx.android.synthetic.main.bulgogipizza.plus_pizza_plus_picle
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.gogumapizza.*

class PizzaGogumaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gogumapizza)
        var price: Int = 12500
        pizza_plus_colla.setOnCheckedChangeListener { compoundButton, b ->
            if (pizza_plus_colla.isChecked == true) {
                price += 2000
                pizza_goguma_price.text = "가격: "+price
            } else
                price -= 2000
            pizza_goguma_price.text = "가격: "+price



        }
        pizza_plus_spageti.setOnCheckedChangeListener { compoundButton, b ->
            if (pizza_plus_spageti.isChecked == true) {
                price += 2500
                pizza_goguma_price.text = "가격: "+price
            } else
                price -= 2500
            pizza_goguma_price.text = "가격: "+price



        }
        pizza_plus_hotsource.setOnCheckedChangeListener { compoundButton, b ->
            if (pizza_plus_hotsource.isChecked == true) {
                price += 500
                pizza_goguma_price.text = "가격: "+price
            } else
                price -= 500
            pizza_goguma_price.text = "가격: "+price



        }
        plus_pizza_plus_chlisource.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_pizza_plus_chlisource.isChecked == true) {
                price += 500
                pizza_goguma_price.text = "가격: "+price
            } else
                price -= 500
            pizza_goguma_price.text = "가격: "+price



        }
        plus_pizza_plus_picle.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_pizza_plus_picle.isChecked == true) {
                price += 500
                pizza_goguma_price.text = "가격: "+price
            } else
                price -= 500
            pizza_goguma_price.text = "가격: "+price



        }
        plus_pizza_plus_cheeze.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_pizza_plus_cheeze.isChecked == true) {
                price += 500
                pizza_goguma_price.text = "가격: "+price
            } else
                price -= 500
            pizza_goguma_price.text = "가격: "+price



        }




    }
}
