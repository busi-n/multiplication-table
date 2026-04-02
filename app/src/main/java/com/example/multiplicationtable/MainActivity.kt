package com.example.multiplicationtable

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val tableNumberTxt =
                  findViewById<EditText>(R.id.tableNumberTxt)
        multiplyButton.setOnClickListener {
           //create the explicit intent
            val intent = Intent(this, table_display::class.java)
            startActivity(intent)
            //add the table number to the intent
            intent.putExtra("tableNumber",
                        tableNumberTxt.text.toString())
            //start the net activity
            startActivity(intent)

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clickMeBtn)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}