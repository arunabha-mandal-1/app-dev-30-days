package com.example.listviewandadapterstwo

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Arunabha", "Kittu", "Samrat", "Babai", "Kushal")
        val lastMsg = arrayOf("How are you?", "Hi!!", "How's it going", "Come soon!", "Get ready!")
        val lastMsgTime = arrayOf("6:45 AM", "9:23 PM", "5:42 AM", "6:02 AM", "3:41 AM")
        val phNo = arrayOf("8545236584", "8545236587", "8545235584", "7545236584", "6545236584")
        val imageId = intArrayOf(R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile)

        userArrayList = ArrayList()
        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phNo[eachIndex], imageId[eachIndex])
            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            // Open a new activity
            val userName = name[i]
            val userPhone = phNo[i]
            val imgId = imageId[i]

            val intentUser = Intent(this, UserActivity::class.java)
            intentUser.putExtra("name", userName)
            intentUser.putExtra("phone", userPhone)
            intentUser.putExtra("imageId", imgId)
            startActivity(intentUser)
        }
    }
}