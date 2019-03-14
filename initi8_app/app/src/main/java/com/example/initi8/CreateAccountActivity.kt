package com.example.initi8

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_create_account.*


class CreateAccountActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        //get widgets
        val createAccountBtn = findViewById<Button>(R.id.create_account)
        createAccountBtn.setOnClickListener(this)

        auth = FirebaseAuth.getInstance()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun createAccount(email: String, password: String) {
        Log.d(TAG, "createAccount:$email")
        if (!validateForm()) {
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createsUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                }
                else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }

            }
    }


    //FIXME
    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {

        }
        else {

        }
    }

    private fun validateForm(): Boolean {
        var valid = true


        val email = email2.text.toString()
        if (TextUtils.isEmpty(email)) {
            email2.error = "Required."
            valid = false
        }
        else {
            email2.error = null
        }

        val password = password2.text.toString()
        if(TextUtils.isEmpty(password)) {
            password2.error = "Required."
            valid = false
        }
        else {
            password2.error = null
        }

        return valid
    }

    override fun onClick(v: View) {
        val i = v.id
        when (i) {
            R.id.create_account -> createAccount(email2.text.toString(), password2.text.toString())
        }
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}

