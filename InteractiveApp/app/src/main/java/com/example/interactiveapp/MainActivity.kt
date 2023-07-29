package com.example.interactiveapp

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonRead = findViewById<Button>(R.id.btnRead)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

        buttonDark.setOnClickListener {
            // Change to dark mode
            layout.setBackgroundResource(R.color.black)
        }
        buttonRead.setOnClickListener {
            // Change to light mode
            layout.setBackgroundResource(R.color.yellow)
        }
    }
}
