package edu.dongyang.cs.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.buybburingcle.*
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.buyzzazzang.*

class ZzazangActivivy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buyzzazzang)
        var price: Int = 4500
        chinafood_colla_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_colla_plus.isChecked == true) {
                price += 2000
                china_zzazang_price.text = "가격: "+price
            } else
                price -= 2000
            china_zzazang_price.text = "가격: "+price



        }
        chinafood_mandu_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_mandu_plus.isChecked == true) {
                price += 500
                china_zzazang_price.text = "가격: "+price
            } else
                price -= 500
            china_zzazang_price.text = "가격: "+price



        }
        chinafood_zzambbong_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_zzambbong_plus.isChecked == true) {
                price += 500
                china_zzazang_price.text = "가격: "+price
            } else
                price -= 500
            china_zzazang_price.text = "가격: "+price



        }
        chinafood_cucumble_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_cucumble_plus.isChecked == true) {
                price += 500
                china_zzazang_price.text = "가격: "+price
            } else
                price -= 500
            china_zzazang_price.text = "가격: "+price



        }
        chinafood_fish_plus.setOnCheckedChangeListener { compoundButton, b ->
            if (chinafood_fish_plus.isChecked == true) {
                price += 2500
                china_zzazang_price.text = "가격: "+price
            } else
                price -= 2500
            china_zzazang_price.text = "가격: "+price



        }




    }
}
