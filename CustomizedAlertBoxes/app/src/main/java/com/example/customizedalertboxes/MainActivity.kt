package com.example.customizedalertboxes

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.customizedalertboxes.databinding.ActivityMainBinding
import com.example.customizedalertboxes.databinding.CustomDialogueBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var bindingDialog : CustomDialogueBinding

    // Create a variable of type Dialog
    private lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindingDialog = CustomDialogueBinding.inflate(layoutInflater)
        dialog = Dialog(this)
        dialog.setContentView(bindingDialog.root)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alert_shape))

        // btnClick in activity_main, btnFeedback and btnGood in custom_dialogue
        bindingDialog.btnGood.setOnClickListener {
            dialog.dismiss()
        }
        bindingDialog.btnFeedback.setOnClickListener {
            // Intent or Toast
            Toast.makeText(this, "You've submitted your feedback!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        binding.btnClick.setOnClickListener {
            dialog.show()
        }
    }
}