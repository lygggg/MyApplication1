package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.buyzzazzang.*
import kotlinx.android.synthetic.main.event_activity.*
import kotlinx.android.synthetic.main.falbochae.*

class FalbochaeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.falbochae)
        var price: Int = 4500
        chinafood_falbochae_colla.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_falbochae_colla.isChecked == true) {
                price += 2000
                china_falbochae_price.text = "가격: "+price
            } else
                price -= 2000
            china_falbochae_price.text = "가격: "+price



        }
        chinafood_falbochae_mandu.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_falbochae_mandu.isChecked == true) {
                price += 500
                china_falbochae_price.text = "가격: "+price
            } else
                price -= 500
            china_falbochae_price.text = "가격: "+price



        }
        chinafood_falbochae_zzambbong.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_falbochae_zzambbong.isChecked == true) {
                price += 500
                china_falbochae_price.text = "가격: "+price
            } else
                price -= 500
            china_falbochae_price.text = "가격: "+price



        }
        chinafood_falbochae_cucumble.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_falbochae_cucumble.isChecked == true) {
                price += 500
                china_falbochae_price.text = "가격: "+price
            } else
                price -= 500
            china_falbochae_price.text = "가격: "+price



        }
        chinafood_falbochae_fish.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_falbochae_fish.isChecked == true) {
                price += 2500
                china_falbochae_price.text = "가격: "+price
            } else
                price -= 2500
            china_falbochae_price.text = "가격: "+price



        }




    }
    override fun onStop() {
        super.onStop()
        setContentView(R.layout.event_activity)
        btn_mainclass.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
