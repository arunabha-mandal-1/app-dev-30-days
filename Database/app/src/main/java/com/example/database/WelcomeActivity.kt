package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val welcomeText = findViewById<TextView>(R.id.tvWelcome)
        val nameText = findViewById<TextView>(R.id.tvName)
        val emailText = findViewById<TextView>(R.id.tvEmail)

        val bundle = intent.extras
        if (bundle != null) {
            welcomeText.text = "Welcome, ${bundle.getString(SignInActivity.KEY2)}!"
            nameText.text = "Name: ${bundle.getString(SignInActivity.KEY2)}"
            emailText.text = "Email: ${bundle.getString(SignInActivity.KEY1)}"
        }
    }
}