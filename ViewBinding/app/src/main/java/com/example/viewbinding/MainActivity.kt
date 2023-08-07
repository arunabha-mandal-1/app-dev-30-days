package com.example.viewbinding

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.core.content.res.ResourcesCompat
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            if (binding.checkBox.isChecked) {
                binding.checkBox.buttonTintList = ColorStateList.valueOf(ResourcesCompat.getColor(resources, R.color.black, null))
                // Open a new screen
            } else {
                binding.checkBox.buttonTintList = ColorStateList.valueOf(ResourcesCompat.getColor(resources, R.color.red, null))
                Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
