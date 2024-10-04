package com.example.empowering_the_nation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SewinInfo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sewin_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sewingBackBtn: Button = findViewById(R.id.sewingBackBtn)
        sewingBackBtn.setOnClickListener {
            val intent = Intent(this, SixMonthsCourses::class.java)
            startActivity(intent)
        }
        
        val sewingCourse = ContactFees.Course(name = "Sewing Course", price = 1200.0)

        // Add to basket functionality
        val sewingaddBasket: Button = findViewById(R.id.sewingaddBasket)
        sewingaddBasket.setOnClickListener {
            // Add the course to the basket
            ContactFees.Basket.addCourse(sewingCourse)

           //Show a message to the user
            Toast.makeText(this, "${sewingCourse.name} added to basket", Toast.LENGTH_SHORT).show()
        }
    }
}