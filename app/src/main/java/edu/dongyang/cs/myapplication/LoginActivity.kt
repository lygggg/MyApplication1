package edu.dongyang.cs.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.GoogleAuthProvider
import io.opencensus.tags.Tag
import kotlinx.android.synthetic.main.login.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.firebase.database.FirebaseDatabase


class LoginActivity: AppCompatActivity(){
    private val RC_SIGN_IN = 9001
    private var mGoogleSignInClient: GoogleSignInClient? = null
    private lateinit var firebasAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        firebasAuth = FirebaseAuth.getInstance()
        Toast.makeText(this,"환영합니다..",Toast.LENGTH_SHORT).show()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso)

        google_button.setOnClickListener {
            signIn()
        }

        btn_Login.setOnClickListener {
            loginId()

        }
        btn_login_signup.setOnClickListener {
            startActivity(Intent(this, JoinActivity::class.java))
        }
    }
    private fun signIn() {
        Toast.makeText(this,"BT..",Toast.LENGTH_SHORT).show()
        val signIntent = mGoogleSignInClient?.signInIntent
        startActivityForResult(signIntent,RC_SIGN_IN)
    }

    private fun loginId(){
        firebasAuth!!.signInWithEmailAndPassword(edit_email.text.toString(),edit_password.text.toString())
            .addOnCompleteListener(this){
                if(it.isSuccessful){

                    var user = firebasAuth?.currentUser
                    var name = user!!.displayName
                    Toast.makeText(this,"로그인 되었습니다.."+name,Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, ChatRoomActivity::class.java))
                }else{
                    Toast.makeText(this,"로그인에 실패하셨습니다.",Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode === RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)

            }catch (e: ApiException){

            }
        }
    }
    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount){
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebasAuth.signInWithCredential(credential)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    val user = firebasAuth.currentUser
                    var name = user!!.email
                    Toast.makeText(this,"로그인 되었습니다..",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ChatRoomActivity::class.java)
                    intent.putExtra("userName",name.toString() )
                    startActivity(intent)

                }else{
                    Toast.makeText(this,"로그인을 실패하였습니다..",Toast.LENGTH_SHORT).show()
                }
            }
    }






}