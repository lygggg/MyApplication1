package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.buyzzazzang.*
import kotlinx.android.synthetic.main.buyzzazzang.chinafood_colla_plus
import kotlinx.android.synthetic.main.buyzzazzang.chinafood_cucumble_plus
import kotlinx.android.synthetic.main.buyzzazzang.chinafood_fish_plus
import kotlinx.android.synthetic.main.buyzzazzang.chinafood_mandu_plus
import kotlinx.android.synthetic.main.buyzzazzang.chinafood_zzambbong_plus
import kotlinx.android.synthetic.main.event_activity.*
import kotlinx.android.synthetic.main.jobchaebob.*

class JabchaeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jobchaebob)
        var price: Int = 4500
        chinafood_colla_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_colla_plus.isChecked == true) {
                price += 2000
                china_jabchae_price.text = "가격: "+price
            } else
                price -= 2000
            china_jabchae_price.text = "가격: "+price



        }
        chinafood_mandu_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_mandu_plus.isChecked == true) {
                price += 500
                china_jabchae_price.text = "가격: "+price
            } else
                price -= 500
            china_jabchae_price.text = "가격: "+price



        }
        chinafood_zzambbong_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_zzambbong_plus.isChecked == true) {
                price += 500
                china_jabchae_price.text = "가격: "+price
            } else
                price -= 500
            china_jabchae_price.text = "가격: "+price



        }
        chinafood_cucumble_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_cucumble_plus.isChecked == true) {
                price += 500
                china_jabchae_price.text = "가격: "+price
            } else
                price -= 500
            china_jabchae_price.text = "가격: "+price



        }
        chinafood_fish_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_fish_plus.isChecked == true) {
                price += 2500
                china_jabchae_price.text = "가격: "+price
            } else
                price -= 2500
            china_jabchae_price.text = "가격: "+price



        }




    }
    override fun onStop() {
        super.onStop()
        setContentView(R.layout.event_activity)
        btn_mainclass.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
