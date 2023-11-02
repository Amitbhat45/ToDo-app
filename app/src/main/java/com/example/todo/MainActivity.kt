package com.example.todo

import adapterclass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val taskList = mutableListOf<tododataclass>() // This list will hold your tasks
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        val adapter = adapterclass(taskList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addTaskButton = findViewById<Button>(R.id.button3)
        val taskNameEditText = findViewById<EditText>(R.id.editTextText)


        addTaskButton.setOnClickListener {
            val name = taskNameEditText.text.toString()


            if (name.isNotEmpty()) {
                val newTask = tododataclass(name)
                taskList.add(newTask)
                adapter.notifyItemInserted(taskList.size - 1)
                taskNameEditText.text.clear()

            }
        }
    }
}








