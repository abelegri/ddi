package com.example.initi8

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainAcitivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get widgets
        val signInButton = findViewById<Button>(R.id.button)
        val createAccountButton = findViewById<Button>(R.id.button2)

        createAccountButton.setOnClickListener{
            val intent = Intent(this, CreateAccountActivity::class.java).apply {}
            startActivity(intent)
        }

        signInButton.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java).apply {}
            startActivity(intent)
        }

    }
}

