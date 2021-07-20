package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var Tododapter:todoadapter // Lateinit is allowed for non-primitive data types only and the variable can't be of null type.

    override fun onCreate(savedInstanceState: Bundle?) { // oncreate fun : called when we lance the app
        super.onCreate(savedInstanceState)
        val  binding = com.example.myapplication.databinding.ActivityMainBinding.inflate(layoutInflater)
//        val binding = ActivityMainBinding.inflate(getLayoutInflater(),viewGroup,false)
        setContentView(binding.root)

        // assign a new todoadapter to a todoadapter file
        Tododapter= todoadapter(mutableListOf())//mutableListOf(): allow us to pass a mutable list

        // reassign todoadapter to recycleview adapter
        // activity_main.xml become a class name activityMainBinding
        binding.reviewbar.adapter= Tododapter

        // layout manager : definies how the items are  arranged in our list

        binding.reviewbar.layoutManager = LinearLayoutManager(this )

        binding.ButAdd.setOnClickListener {                    //set behavior for addtodo button
            // put your logic
            val todotitle = binding.Editbar.text.toString()
            if (todotitle.isNotEmpty()) {
                val todo: todo = todo(todotitle)
                Tododapter.addtodo(todo)
                binding.Editbar.text.clear()
            }
        }
        binding.ButDel.setOnClickListener(){                 //set behavior for addtodo button
            Tododapter.deletetodo()
        }


    }
}