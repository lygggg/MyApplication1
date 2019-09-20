package edu.dongyang.cs.myapplication

import android.content.Intent
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.event_activity.*
import kotlinx.android.synthetic.main.membership.*

class MainActivity : AppCompatActivity() {
    var mediaPlayer : MediaPlayer?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        Toast.makeText(this, "YOGIYO", Toast.LENGTH_SHORT).show()
         mediaPlayer = MediaPlayer.create(this, R.raw.yogiyo1)
        mediaPlayer?.start()
        btn_main_search.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_buylist.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_myyogiyo.setOnClickListener {
            val intent = Intent(this, MyyogiyoActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_pizza.setOnClickListener {
            val intent = Intent(this, PizzamenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_chinafood.setOnClickListener {
            val intent = Intent(this, ChinafoodMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_chicken.setOnClickListener {
            val intent = Intent(this, ChickenMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_bunsik.setOnClickListener {
            val intent = Intent(this, BunsikMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_hansik.setOnClickListener {
            val intent = Intent(this, YasikMenuMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_main_jokbal.setOnClickListener {
            val intent = Intent(this, YasikMenuMenuActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_main_sushi.setOnClickListener {
            val intent = Intent(this, SushiMenuMenuActivity::class.java)
            startActivity(intent)
            finish()

        }
        btn_maps.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            finish()
        }



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
