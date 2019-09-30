package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.buy_list.*
import kotlinx.android.synthetic.main.buyhuride.*
import kotlinx.android.synthetic.main.buylist.*
import org.json.JSONArray
import org.json.JSONObject

class BuyListActivity : AppCompatActivity(){
    lateinit var nameKey : String
    lateinit var priceKey : String
    val jsonArray = JSONArray()
    val jsonObject = JSONObject()
    private val adapter by lazy {
        BuyListAdapter()
    }
    private val pref by lazy {
        this.getPreferences(0)
    }
    private val editor by lazy {
        pref.edit()
    }
    var memoSize: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buylist)

        if(intent.hasExtra("nameKey")) {
            Log.d("TAG", "메세지" + "has")

            nameKey = intent.getStringExtra("nameKey").toString()
            priceKey = intent.getStringExtra("priceKey").toString()
        }




            btn_buylist.setOnClickListener {
                adapter.addItem(BuyList(nameKey, priceKey))
                Log.d("TAG", "메세지" + "add")
                jsonObject.put("name",nameKey)
                jsonObject.put("price",priceKey)
                jsonArray.put(jsonObject)
                var jsondata = jsonArray.toString()
                if (memoSize >= 0) {

                    editor.putString("buy${adapter.items.size}", jsondata).apply()



                    memoSize++
                    editor.putInt("memoSize", memoSize).apply()

                }
            }





        rv_buy_list.layoutManager = LinearLayoutManager(this)
        rv_buy_list.adapter = adapter
        rv_buy_list.setHasFixedSize(true)


        memoSize = pref.getInt("memoSize", 0)
        if (memoSize > 0) {
            Log.d("TAG", "메세지" +"if")

            for (i in 1..memoSize) {

                var name = pref.getString("name","")
                var price = pref.getString("price","")
                adapter.addItem(BuyList(name,price))
                Log.d("TAG", "메세지" +"finish")

            }
        }
    }
}
