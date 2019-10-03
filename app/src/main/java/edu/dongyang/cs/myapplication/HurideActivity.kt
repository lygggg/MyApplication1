package edu.dongyang.cs.myapplication

import android.app.ProgressDialog

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.buybburingcle.plus_colla
import kotlinx.android.synthetic.main.buybburingcle.plus_dellisauce
import kotlinx.android.synthetic.main.buybburingcle.plus_mayosauce
import kotlinx.android.synthetic.main.buybburingcle.plus_mu
import kotlinx.android.synthetic.main.buybburingcle.plus_potato

import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.event_activity.*


class HurideActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buyhuride)
        var price: Int = 15000
        var result: String

        plus_colla.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_colla.isChecked == true) {
                price += 2000
                huride_price.text = "가격: "+price
                result = plus_colla.getText().toString()+","
                textView1.setText(result)
            } else
                price -= 2000
            huride_price.text = "가격: "+price
            textView1.setText("")



        }
        plus_dellisauce.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_dellisauce.isChecked == true) {
                price += 500
                huride_price.text = "가격: "+price
                result= plus_potato.getText().toString()+","
                textView1.setText(result)
            } else
                price -= 500
            huride_price.text = "가격: "+price



        }
        plus_mayosauce.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_mayosauce.isChecked == true) {
                price += 500
                huride_price.text = "가격: "+price
            } else
                price -= 500
            huride_price.text = "가격: "+price



        }
        plus_mu.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_mu.isChecked == true) {
                price += 500
                huride_price.text = "가격: "+price
            } else
                price -= 500
            huride_price.text = "가격: "+price



        }
        plus_potato.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_potato.isChecked == true) {
                price += 2500
                huride_price.text = "가격: "+price
            }else
            price -= 2500
            huride_price.text = "가격: "+price



        }
        plus_potato.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_potato.isChecked == true) {
                price += 2500
                huride_price.text = "가격: "+price
            }else
                price -= 2500
            huride_price.text = "가격: "+price



        }
        plus_spicyysauce.setOnCheckedChangeListener { compoundButton, b ->
            if (plus_potato.isChecked == true) {
                price += 2500
                huride_price.text = "가격: "+price
            }else
                price -= 2500
            huride_price.text = "가격: "+price



        }
        btn_buy.setOnClickListener {

            val intent = Intent(this,BuyListActivity::class.java)
            intent.putExtra("nameKey",menu_name_huride.text.toString())
            intent.putExtra("priceKey",huride_price.text.toString())

            startActivity(intent)
            finish()
        }

        }

    }





