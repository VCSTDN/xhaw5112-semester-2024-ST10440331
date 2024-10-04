package com.example.empowering_the_nation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactFees : AppCompatActivity() {

    // Initialize RecyclerView and Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_fees)

        // Set up WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val coursePrice: TextView = findViewById(R.id.sixweekBtn)



        // Initialize RecyclerView
        recyclerView = findViewById(R.id.courseName)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter with the list of courses from the basket
        adapter = CourseAdapter(Basket.coursesInBasket) // Assuming you have a global Basket object
        recyclerView.adapter = adapter
    }
    val sewingCourse = Course(name = "Sewing Course", price = 1200.0)
    val gardenCourse = Course(name = "Garden Course", price = 1200.0)
    val LifeSkillsCourse = Course(name = "Life Skills Course", price = 1200.0)
    val LandSapingCourse = Course(name = "LandScaping Course", price = 1200.0)
    val FirstAidCourse = Course(name = "First Aid Course", price = 1200.0)
    val CookingCourse = Course(name = "Cooking Course", price = 1200.0)
    val ChildMindingCourse = Course(name = "Child Minding Course", price = 1200.0)

    class Basket {
        companion object {
            val coursesInBasket = mutableListOf<Course>()
        }
    }

    data class Course(
        val name: String,
        val price: Double
    )
}
