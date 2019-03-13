package com.example.initi8

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainAcitivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Called when user taps Sign In **/
        fun signIn(view: View){
            val intent = Intent(this, SignInActivity::class.java).apply {}
            startActivity(intent)
        }

        fun createAccount(view: View){
            val intent = Intent(this, CreateAccountActivity::class.java).apply {}
            startActivity(intent)
        }
    }
}
