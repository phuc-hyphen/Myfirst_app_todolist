package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var Todoadapter:todoadapter // Lateinit is allowed for non-primitive data types only and the variable can't be of null type.
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) { // oncreate fun : called when we lance the app
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val binding = ActivityMainBinding.inflate(getLayoutInflater(),viewGroup,false)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        // assign a new todoadapter to a todoadapter file
        Todoadapter= todoadapter(mutableListOf())//mutableListOf(): allow us to pass a mutable list

        // reassign todoadapter to recycleview adapter // activity_main.xml become a class name activityMainBinding

        reviewbar.adapter= Todoadapter
        reviewbar.layoutManager = LinearLayoutManager(this )// layout manager : definies how the items are  arranged in our list


        //set behavior for addtodo button
        ButAdd.setOnClickListener {
            // put your logic
            val todotitle = Editbar.text.toString()
            if (todotitle.isNotEmpty()) {
                val Todo = todo(todotitle)
                Todoadapter.addtodo(Todo)
                Editbar.text.clear()
            }
        }
        ButDel.setOnClickListener(){                 //set behavior for addtodo button
            Todoadapter.deletetodo()
        }


    }
}