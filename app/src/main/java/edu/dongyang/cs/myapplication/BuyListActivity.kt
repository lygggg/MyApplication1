package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.buylist.*


class BuyListActivity : AppCompatActivity(){
    lateinit var nameKey : String
    lateinit var priceKey : String


    private val adapter by lazy {
        BuyListAdapter { buyList: BuyList -> buyListClicked(buyList) }
    }

    var memoSize: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buylist)

        if(intent.hasExtra("nameKey")) {
            Log.d("TAG", "메세지" + "has")
            super.onStop()
            val builder = AlertDialog.Builder(this)
            val dialogView =layoutInflater.inflate(R.layout.progress_dialog,null)
            val message = dialogView.findViewById<TextView>(R.id.message)
            message.text = "결제 처리중입니다..."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog = builder.create()
            dialog.show()
            Handler().postDelayed({dialog.dismiss()},500)
            nameKey = intent.getStringExtra("nameKey").toString()
            priceKey = intent.getStringExtra("priceKey").toString()
            adapter.addItem(BuyList(nameKey, priceKey))
        }






        rv_buy_list.layoutManager = LinearLayoutManager(this)
        rv_buy_list.adapter = adapter
        rv_buy_list.setHasFixedSize(true)



    }
    private fun buyListClicked(buyList: BuyList){
        val intent = Intent(this, ReviewActivity::class.java)
        intent.putExtra("buyName",buyList.name)
        startActivity(intent)
    }
}
