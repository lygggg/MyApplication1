package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.pizzamenu.*

class ReviewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.customerreview,null)
        val dialogText = dialogView.findViewById<EditText>(R.id.dialogEt)
        val dialogRatingBar = dialogView.findViewById<RatingBar>(R.id.dialogRb)

        builder.setView(dialogView)
            .setPositiveButton("확인") { dialogInterface, i ->
                mainTv.text = dialogText.text.toString()
                mainRb.rating = dialogRatingBar.rating
                /* 확인일 때 main의 View의 값에 dialog View에 있는 값을 적용 */

            }
            .setNegativeButton("취소") { dialogInterface, i ->
                /* 취소일 때 아무 액션이 없으므로 빈칸 */
            }
            .show()


    }
}