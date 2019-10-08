package edu.dongyang.cs.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextClock
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mediaPlayer : MediaPlayer?= null
    private  var first_time : Long = 0
    private  var second_time : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var clock = findViewById(R.id.clock) as TextClock
        clock

        Toast.makeText(this, "YOGIYO", Toast.LENGTH_SHORT).show()
         mediaPlayer = MediaPlayer.create(this, R.raw.yogiyo1)
        mediaPlayer?.start()
        btn_main_search.setOnClickListener {
            Log.d("TAG", "Start")
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)

        }
        btn_main_buylist.setOnClickListener {
            val intent = Intent(this, BuyListActivity::class.java)
            startActivity(intent)

        }
        btn_main_myyogiyo.setOnClickListener {
            val intent = Intent(this, MyyogiyoActivity::class.java)
            startActivity(intent)

        }
        btn_main_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        btn_main_pizza.setOnClickListener {
            val intent = Intent(this, PizzamenuActivity::class.java)
            startActivity(intent)

        }
        btn_main_chinafood.setOnClickListener {
            val intent = Intent(this, ChinafoodMenuActivity::class.java)
            startActivity(intent)

        }
        btn_main_chicken.setOnClickListener {
            val intent = Intent(this, ChickenMenuActivity::class.java)
            startActivity(intent)

        }
        btn_main_bunsik.setOnClickListener {
            val intent = Intent(this, BunsikMenuActivity::class.java)
            startActivity(intent)

        }
        btn_main_hansik.setOnClickListener {
            val intent = Intent(this, YasikMenuMenuActivity::class.java)
            startActivity(intent)

        }
        btn_main_jokbal.setOnClickListener {
            val intent = Intent(this, YasikMenuMenuActivity::class.java)
            startActivity(intent)

        }

        btn_main_sushi.setOnClickListener {
            val intent = Intent(this, SushiMenuMenuActivity::class.java)
            startActivity(intent)


        }
        btn_maps.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }







    }

    override fun onBackPressed() {
        second_time = System.currentTimeMillis()
        if(second_time - first_time < 2000){
            super.onBackPressed()
            finish()
        }else Toast.makeText(this,"뒤로가기 버튼을 한 번 더 누르시면 종료!",Toast.LENGTH_SHORT).show()
        first_time = System.currentTimeMillis()

    }
    override fun onStart() {
        super.onStart()

        // The activity is about to become visible.

    }

    override fun onResume() {
        super.onResume()
        // The activity has become visible (it is now "resumed").

    }

    override fun onPause() {
        super.onPause()
        // Another activity is taking focus (this activity is about to be "paused").
        mediaPlayer?.release()

    }



    override fun onDestroy() {
        super.onDestroy()

        // The activity is about to be destroyed.

    }
}
