package edu.dongyang.cs.myapplication

import java.io.Serializable

class User (
    val uid: String = "",
    val userName: String = "",
    var rooms: MutableMap<String, Any>? = null
) : Serializable