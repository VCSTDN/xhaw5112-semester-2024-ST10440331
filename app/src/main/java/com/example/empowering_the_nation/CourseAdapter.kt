package com.example.empowering_the_nation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(private val courseList: List<ContactFees.Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    // ViewHolder class to hold the view for each item
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseName: TextView = itemView.findViewById(R.id.courseName) // Ensure this ID matches your layout
        val coursePrice: TextView = itemView.findViewById(R.id.courcePrice) // Ensure this ID matches your layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_contact_fees, parent, false) // Ensure this layout exists
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.courseName.text = course.name
        holder.coursePrice.text = "$${course.price}" // Format as needed
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
