package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    companion object{
        const val KEY1 = "com.example.day16database.SignInActivity.mail"
        const val KEY2 = "com.example.day16database.SignInActivity.name"
        const val KEY3 = "com.example.day16database.SignInActivity.id"
    }
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val signInBtn = findViewById<Button>(R.id.btnSignIn)
        val userName = findViewById<EditText>(R.id.userNameEt)
        signInBtn.setOnClickListener {
            val uniqueId = userName.text.toString()
            if (uniqueId.isNotEmpty()) {
                readData(uniqueId)
            } else {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uniqueId).get().addOnSuccessListener {
            // Check if user exists or not
            if (it.exists()) {
                // Welcome user in your app
                val email = it.child("email").value
                val name = it.child("name").value
                val id = it.child("uniqueId").value

               val bundle = Bundle()
                bundle.putString(KEY1, email.toString())
                bundle.putString(KEY2, name.toString())
                bundle.putString(KEY3, id.toString())

                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(this, "User doesn't exist!", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            // In case app can't deal with database
            Toast.makeText(this, "Failed, Error in DB", Toast.LENGTH_SHORT).show()
        }
    }
}