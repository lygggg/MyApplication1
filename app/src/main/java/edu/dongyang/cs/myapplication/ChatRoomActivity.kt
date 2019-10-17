package edu.dongyang.cs.myapplication

import android.content.Intent
import android.icu.util.ULocale
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_chatroom.*
import kotlinx.android.synthetic.main.item_message.view.*

class ChatRoomActivity  : AppCompatActivity() {
    private lateinit var mFirebaseAuth: FirebaseAuth
    private lateinit var mFirebaseUser: FirebaseUser
    private var adapter: ProductFirestoreRecyclerAdapter? = null

    lateinit var mUserName: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)
        val db = FirebaseFirestore.getInstance()
        val query = db!!.collection("messages")
        val options = FirestoreRecyclerOptions
            .Builder<ChatItem>()
            .setQuery(query,ChatItem::class.java)
            .build()

       adapter = ProductFirestoreRecyclerAdapter(options)
        chatRoomList.adapter = adapter

        chatRoomList.layoutManager = LinearLayoutManager(this)
        chatRoomList.setHasFixedSize(true)

        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirebaseUser = mFirebaseAuth.currentUser!!

        if (mFirebaseUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        }


        btn_send.setOnClickListener {
            mUserName = mFirebaseUser.email.toString()
            var chat = hashMapOf(
                "name" to mUserName,
                "message" to message_edit.text.toString()
            )

            db.collection("messages")
                .add(chat)

            message_edit.setText("")
        }

    }

    private inner class ProductViewHolder internal constructor(private val view: View) : RecyclerView.ViewHolder(view) {
        internal fun setProductName(name: String, message: String) {
            val nameView = view.findViewById<TextView>(R.id.friend_NameTxtView)
            val messageView = view.findViewById<TextView>(R.id.friend_message)
            nameView.text = name
            messageView.text = message
        }
    }
    private inner class ProductFirestoreRecyclerAdapter internal constructor(options: FirestoreRecyclerOptions<ChatItem>) : FirestoreRecyclerAdapter<ChatItem, ProductViewHolder>(options) {
        override fun onBindViewHolder(productViewHolder: ProductViewHolder, position: Int, productModel: ChatItem) {
            productViewHolder.setProductName(productModel.name,productModel.message)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
            return ProductViewHolder(view)
        }
    }
    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()

        if (adapter != null) {
            adapter!!.stopListening()
        }
    }
}