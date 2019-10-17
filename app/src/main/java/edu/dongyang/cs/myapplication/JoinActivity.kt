package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.joinn.*
import kotlinx.android.synthetic.main.login.*
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class JoinActivity : AppCompatActivity() {
    private var firebasAuth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.joinn)
        firebasAuth = FirebaseAuth.getInstance()

        finish_task.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.progress_dialog, null)
            val message = dialogView.findViewById<TextView>(R.id.message)
            message.text = "회원가입중입니다..."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog = builder.create()
            dialog.show()
            Handler().postDelayed({
                createId()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            },2000)
        }

        Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show()
    }
    private fun createId(){
        firebasAuth!!.createUserWithEmailAndPassword(make_Id.text.toString(), make_password.text.toString())
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    val user = firebasAuth?.currentUser
                    Toast.makeText(this,"계정을 생성하였습니다.",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"계정생성에 실패하였습니다",Toast.LENGTH_SHORT).show()
                }
            }
    }
}
