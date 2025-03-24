package com.example.mealideasapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Mealdisplay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mealdisplay)

        //Reference to UI
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val getmealBtn = findViewById<Button>(R.id.getmealBtn)
        val mealResult = findViewById<TextView>(R.id.mealResult)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        //Different meal options
        val meals = mapOf(
            "Morning" to listOf("Bacon & Eggs", "Oats & Yogurt", "Waffles & Syrup"),
            "Mid-Morning" to listOf("Protein Smoothie", "Energy Bar", "Eggs on Toast"),
            "Afternoon" to listOf("Pasta with Pesto", "Rice & Stew", "Chicken & Potatoes"),
            "Mid-Afternoon" to listOf("Cottage Cheese & Crackers", "Biscuits & Tea", "Fruit Salad"),
            "Evening" to listOf("Grilled Chicken & Veggies", "Soup", "Rice Stir Fry"))

        //"Get Meal" Button
        getmealBtn.setOnClickListener{
            //Generate random meals
            val input = timeInput.text.toString().trim()
            if (meals.containsKey(input)) {
                val meal = meals[input]?.random()
                mealResult.text = "$meal"
            } else {
                //Error message
                Toast.makeText(this, "Please enter a valid time of day!", Toast.LENGTH_SHORT).show()
                mealResult.text = "Invalid Time of Day!" }
        }

        //"Reset" Button
        clearBtn.setOnClickListener{
            timeInput.text.clear()
            mealResult.text = "" }

        //"Go Back" Button
        exitBtn.setOnClickListener{
            finish() }
    }
}