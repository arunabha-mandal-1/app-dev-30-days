package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments.ui.login.ValidateFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClock = findViewById<Button>(R.id.btnClock)
        val buttonExam = findViewById<Button>(R.id.btnExam)
        val buttonValidate = findViewById<Button>(R.id.btnValidate)

        buttonClock.setOnClickListener {
            replaceFrameWithFragment(ClockFragment())
        }
        buttonExam.setOnClickListener {
            replaceFrameWithFragment(ExamFragment())
        }
        buttonValidate.setOnClickListener {
            replaceFrameWithFragment(ValidateFragment())
        }
    }

    private fun replaceFrameWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}