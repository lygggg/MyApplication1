package edu.dongyang.cs.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.android.synthetic.main.login.*

class LoginActivity: AppCompatActivity(){
    private val RC_SIGN_IN = 9001
    private var firebasAuth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        firebasAuth = FirebaseAuth.getInstance()




    }
    private fun createEmail(){
        firebasAuth!!.createUserWithEmailAndPassword(edit_email.text.toString(), edit_password.text.toString())
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