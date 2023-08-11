package com.example.listviewandadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val taskList = arrayListOf<String>()
        taskList.add("Attend Exam")
        taskList.add("Attend meeting")
        taskList.add("Buy foods")
        taskList.add("Build a project")
        taskList.add("Go to gym")
        taskList.add("Go to college")

        val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listView.adapter = adapterForMyListView

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = "Clicked on item ${(view as TextView).text.toString()}"
            // view as TextView = type casting
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}
