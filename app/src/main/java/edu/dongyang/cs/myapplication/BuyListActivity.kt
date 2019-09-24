package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BuyListActivity : AppCompatActivity(){
    private val adapter by lazy {
        BuyListAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buylist)


    }
}
