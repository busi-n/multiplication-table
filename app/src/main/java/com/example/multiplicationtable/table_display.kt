package com.example.multiplicationtable

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class table_display : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        //get the table number from the bundle
        val bundle: Bundle? = intent.extras
        val tableString: String? = bundle?.getString("tableNumber")
        //convert the table number to an integer
        val tableNumber = tableString!!.toInt()
        var timesDisplay: String = "$tableNumber x table\n\n"
        //display the heaading so we can see the value in action
        val multiplicationTable = findViewById<TextView>(R.id.tableDisplayTxt)
        // creating counter for while loop
        var counter = 1
        multiplicationTable.text = "$tableNumber x table\n\n"

        while (counter <= 10) {
            // example : user enters 5 and count is 1 so 5 x 1 = 5 (answer)
            val answer = tableNumber * counter
            /* displays as follows:
            5 x 1 = 5
            5 x 2 = 10
            */
            timesDisplay = "$tableNumber x $counter = $answer\n"
            //increasing the counter
            counter++
        }

        //loop 10 times and keep adding to the string

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}