package com.example.myapplication

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemTodoBinding


class todoadapter (private var todos: MutableList<todo>):RecyclerView.Adapter<todoadapter.todoViewHolder>()
{
    private var _binding: ItemTodoBinding? = null
    private val binding get() = _binding!!

    class todoViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)
    // class viewholder : a class that warp around a specific view

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {

        val  binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                return todoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_todo,
                        parent,
                        false
                )
        )
    }
    fun addtodo(todo:todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1) // notify our adapter that we inserted an item (reset screen)
    }
    fun deletetodo(){
        todos.removeAll { todo -> todo.ischecked }
        notifyDataSetChanged()
    }

    private fun strike(todotitle:TextView, ischecked:Boolean){
        if(ischecked) todotitle.paintFlags=todotitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        else todotitle.paintFlags=todotitle.paintFlags and STRIKE_THRU_TEXT_FLAG
    }
    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {// set the data of our todo list to text / check box
        val todoTitle:TextView = binding.todoTitle
        val checkBox = binding.checkBox

        val curtodo=todos[position]        // position of the todo item
        holder.itemView.apply{
            todoTitle.text=curtodo.title
            checkBox.isChecked=curtodo.ischecked
            strike(todoTitle,curtodo.ischecked)
            checkBox.setOnCheckedChangeListener { _, isChecked ->  strike(todoTitle,isChecked)
                curtodo.ischecked=!curtodo.ischecked
            }
        }
    }

    override fun getItemCount(): Int {// show how many item that we displayed
        return todos.size
    }
}