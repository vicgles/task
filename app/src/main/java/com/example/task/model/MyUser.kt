package com.example.task.model

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import java.io.Serializable

data class MyUser(val userId:String = "",var userName:String = "",val userEmail:String = "",var userProfile:String = ""): Serializable{

    constructor(fuser: FirebaseUser?, mU: MyUser? = null) : this (fuser?.uid ?: "", mU?.userName?: "",fuser?.email ?:  "", mU?.userProfile?: "")

}