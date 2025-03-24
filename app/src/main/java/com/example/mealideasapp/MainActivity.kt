package com.example.mealideasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declare UI Elements.
    private lateinit var eatBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI Elements.
        val eatBtn: Button = findViewById(R.id.eatBtn)
        val exitBtn: Button = findViewById(R.id.exitBtn)

        // Navigate to 'activity_mealdisplay.xml' when 'Get Your Meal!' button gets clicked.
        eatBtn.setOnClickListener { val intent = Intent(this, Mealdisplay::class.java)
            startActivity(intent) }

        // When "Exit" button is clicked
        exitBtn.setOnClickListener {
            finish()
        }
    }
}

