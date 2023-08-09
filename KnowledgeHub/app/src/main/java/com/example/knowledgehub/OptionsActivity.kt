package com.example.knowledgehub

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgehub.databinding.ActivityOptionsBinding

class OptionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOptionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // App dev
        binding.tvApp.setOnClickListener {
            val intentApp = Intent(this, AppActivity::class.java)
            startActivity(intentApp)
        }

        // Web dev
        binding.tvWeb.setOnClickListener {
            val intentWeb = Intent(this, WebActivity::class.java)
            startActivity(intentWeb)
        }

        // IOS dev
        binding.tvIos.setOnClickListener {
            val intentIos = Intent(this, IosDevActivity::class.java)
            startActivity(intentIos)
        }

        // Machine learning
        binding.tvMl.setOnClickListener {
            val intentMl = Intent(this, MachineLearningActivity::class.java)
            startActivity(intentMl)
        }

        // Data Science
        binding.tvDs.setOnClickListener {
            val intentDs = Intent(this, DataScienceActivity::class.java)
            startActivity(intentDs)
        }

        // Devops
        binding.tvDevops.setOnClickListener {
            val intentDevops = Intent(this, DevopsActivity::class.java)
            startActivity(intentDevops)
        }

        // Help
        binding.btnCallUs.setOnClickListener {
            val phoneNumber = "tel:0123456789"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(phoneNumber)
            startActivity(intent)
        }
    }
}