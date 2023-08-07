package com.example.alertdialogueboxes

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.alertdialogueboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when "yes" is click
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                // // What action should be performed when "no" is click
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmalai", "Rosogolla")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options, -1, DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when user clicks on any option
                Toast.makeText(this, "You want ${options[i]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when "yes" is clicked
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                // // What action should be performed when "no" is clicked
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Mutton", "Prawn", "Ilish", "Doi", "Sweets")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Choose your favourite items!")
            builder3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this, "You want ${options[i]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when "yes" is clicked
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when "no" is clicked
            })
            builder3.show()
        }
    }
}
