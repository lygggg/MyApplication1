package edu.dongyang.cs.myapplication

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import kotlinx.android.synthetic.main.buybburingcle.*
import kotlinx.android.synthetic.main.buybburingcle.plus_colla
import kotlinx.android.synthetic.main.buybburingcle.plus_dellisauce
import kotlinx.android.synthetic.main.buybburingcle.plus_mayosauce
import kotlinx.android.synthetic.main.buybburingcle.plus_mu
import kotlinx.android.synthetic.main.buybburingcle.plus_potato
import kotlinx.android.synthetic.main.buyganjang.*
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.event_activity.*
import kotlinx.android.synthetic.main.guide.*
import kotlinx.android.synthetic.main.guide.view.*
import org.jetbrains.anko.image

class HurideActivity : AppCompatActivity() {
    lateinit var mHandler : Handler
    lateinit var mRunnable: Runnable
    lateinit var animationDrawable :AnimationDrawable
    lateinit var mProgressBar: ImageView

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
            } else
                price -= 2500
            huride_price.text = "가격: "+price



        }
        btn_buy.setOnClickListener {
            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("결제 처리중입니다...")
            progressDialog.setCancelable(false)
            progressDialog.show()
            Handler().postDelayed({progressDialog.dismiss()},5000)

            val intent = Intent(this, ReviewActivity::class.java)
            val buyintent = Intent(this,BuyListActivity::class.java)
            buyintent.putExtra("nameKey",menu_name_huride.text.toString())
            buyintent.putExtra("priceKey",menu_price_huride.text.toString())

            startActivity(intent)
            finish()
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
