package edu.dongyang.cs.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.common.util.MurmurHash3
import kotlinx.android.synthetic.main.buy_list.*
import kotlinx.android.synthetic.main.buylist.*
import kotlinx.android.synthetic.main.chickenmenu.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class BuyListActivity : AppCompatActivity() {
    lateinit var nameKey: String
    lateinit var priceKey: String


    private val adapter by lazy {
        BuyListAdapter { buyList: BuyList -> buyListClicked(buyList) }
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

        val reviewData: MutableList<String> = mutableListOf()
        btn_list_plus.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
            val message = dialogView.findViewById<TextView>(R.id.message)
            message.text = "결제 처리중입니다..."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog = builder.create()
            dialog.show()
            Handler().postDelayed({ dialog.dismiss() }, 3000)
            Log.d("TAG", "메세지" + "has")
            intent.hasExtra("nameKey")
            intent.hasExtra("priceKey")
            nameKey = intent.getStringExtra("nameKey").toString()
            priceKey = intent.getStringExtra("priceKey").toString()
            adapter.addItem(BuyList(nameKey, priceKey))

            if (memoSize >= 0) {
                reviewData.add(nameKey)
                reviewData.add(priceKey)
                StringPref("buy${adapter.items.size}", reviewData)
                memoSize++
                editor.putInt("memosize",memoSize).apply()
            }
        }


        rv_buy_list.layoutManager = LinearLayoutManager(this)
        rv_buy_list.adapter = adapter
        rv_buy_list.setHasFixedSize(true)

        memoSize = pref.getInt("memosize", 0)

        if(memoSize>0){
            for(i in 1..memoSize){
                val prefData = StringGetPref("buy${i}")
                adapter.addItem(BuyList(prefData[0],prefData[1]))
            }
        }
    }

    private fun buyListClicked(buyList: BuyList) {
        val intent = Intent(this, ReviewActivity::class.java)
        intent.putExtra("buyName", buyList.name)
        startActivity(intent)
    }

    private fun StringPref(key: String, BuyList: MutableList<String>) {
        val jsonArray = JSONArray()
        val jsonObject = JSONObject()
        for (i in 0..BuyList.size - 1) {
            jsonArray.put(BuyList.get(i))
        }
        if (!BuyList.isEmpty()) {
            editor.putString(key, jsonArray.toString())
        } else {
            editor.putString(key, null)

        }
        editor.apply()
    }

    private fun StringGetPref(key: String): MutableList<String> {
        val buytaskList: MutableList<String> = mutableListOf()
        val json = pref.getString(key, null)
        if (json != null) {
            try {
                val jsonArray = JSONArray(json)
                for (i in 0..jsonArray.length() - 1) {
                    val address = jsonArray.optString(i)
                    buytaskList.add(address)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return buytaskList

    }
}
