package com.example.database

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpBtn = findViewById<Button>(R.id.btnSignUp)
        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val userId = findViewById<EditText>(R.id.etUserID)
        val userPassword = findViewById<EditText>(R.id.etPassword)

        signUpBtn.setOnClickListener {
            val etName = name.text.toString()
            val etEmail = email.text.toString()
            val uniqueId = userId.text.toString()
            val password = userPassword.text.toString()

            val user = User(etName, etEmail, password, uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                name.text.clear()
                email.text.clear()
                userId.text.clear()
                userPassword.text.clear()
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                Log.i("Firebase", "$uniqueId added")
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                Log.i("Firebase", "Failed to add $uniqueId")
            }
        }
    }
}
