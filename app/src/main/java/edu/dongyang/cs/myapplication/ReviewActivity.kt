package edu.dongyang.cs.myapplication

import android.Manifest
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.item_review.*
import kotlinx.android.synthetic.main.reviewmodify.*
import org.jetbrains.anko.appcompat.v7.buttonBarLayout
import org.jetbrains.anko.progressDialog
import org.json.JSONArray
import org.json.JSONObject

class ReviewActivity: AppCompatActivity() {

    var pos = 0
    val jsonObject = JSONObject()
    val jsonArray = JSONArray()
    lateinit var mHandler: Handler
    lateinit var mRunnable: Runnable



    private val adapter by lazy {
        ReviewListAdapter()
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
        setContentView(R.layout.activity_review)





        btn_Review.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
            val message = dialogView.findViewById<TextView>(R.id.message)
            message.text = "리뷰 작성중..."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog = builder.create()
            dialog.show()
            Handler().postDelayed({ dialog.dismiss() }, 3000)
            adapter.addItem(Buyreview(main_rv.text.toString(), main_rb.rating, main_image.drawable))

        }
        rv_review_list.adapter = adapter
        rv_review_list.layoutManager = LinearLayoutManager(this)
        rv_review_list.setHasFixedSize(true)

        memoSize = pref.getInt("memoSize", 0)
        if (memoSize > 0) {

            Log.d("TAG", "메세지 ==>" + memoSize)
            for (i in 1..memoSize) {
                Log.d("TAG", "메세지 ==>" + "end")
                var name = pref.getString("name", "")


            }
        }

//BUTTON CLICK
        btn_bring_photo.setOnClickListener {

            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    //permission already granted
                        pickImageFromGallery()
                }
            } else {
                    pickImageFromGallery()
            }


        }




        rv_review_list.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

            }

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val child = rv_review_list.findChildViewUnder(e.x, e.y)
                pos = rv_review_list.getChildAdapterPosition(child!!)

                return false

            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

            }
        })

        registerForContextMenu(rv_review_list)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        Log.d("TAG", "메세지" + pos + "sel")

        when (item?.itemId) {

            R.id.modify_dialog -> {
                Log.d("TAG", "메세지" + pos)
                val builder = AlertDialog.Builder(this)
                val dialogView = layoutInflater.inflate(R.layout.reviewmodify, null)
                dialog_review_modify.setText(tv_task_name.toString())
                val dialogmodify = dialogView.findViewById<EditText>(R.id.dialog_review_modify)

                builder.setView(dialogView)
                    .setPositiveButton("확인") { dialogInterface, i ->
                        adapter.removeItem(pos)
                        adapter.addItem1(
                            pos,
                            Buyreview(
                                dialogmodify.text.toString(),
                                main_rb.rating,
                                main_image.drawable
                            )
                        )


                    }
                    .setNegativeButton("취소") { dialogInterface, i ->

                    }.show()

            }
            R.id.remove_dialog -> {
                adapter.removeItem(pos)

            }
        }


        return super.onContextItemSelected(item)
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)

    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    inner class AsyncTaskClass : AsyncTask<Int, Int, Int>() {
        var imageTask = ImageTask(0)

        override fun onPreExecute() {
            super.onPreExecute()
            imageTask

            bar_review.setProgress(imageTask.number)

        }

        override fun doInBackground(vararg p0: Int?): Int {
            while (isCancelled() == false) {
                imageTask.number++
                if (imageTask.number >= 100) {
                    break
                } else {
                    publishProgress(imageTask.number)
                }

                Thread.sleep(50)

            }
            return imageTask.number
        }


        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            bar_review.setProgress(imageTask.number)
            bar_count.setText(imageTask.number.toString() + "%")
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            bar_review.setProgress(0)
            bar_count.setText("완료")
            imageTask.number==0
        }

        override fun onCancelled() {
            super.onCancelled()
            bar_review.setProgress(0)
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var sync = AsyncTaskClass()
        sync.execute()
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            mHandler = Handler()
            mRunnable = Runnable {

                main_image.setImageURI(data?.data)
            }
        }
        mHandler.postDelayed(
            mRunnable,5000
        )


    }
}