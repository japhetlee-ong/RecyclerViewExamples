package com.auf.cea.recyclerviewexamples.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.adapters.SimpleRVAdapter
import com.auf.cea.recyclerviewexamples.databinding.ActivitySimpleRecyclerViewBinding
import com.auf.cea.recyclerviewexamples.models.UsersModel

class SimpleRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameList = arrayListOf(
            UsersModel("juandelacruz",30,"juandelacruz@gmail.com",0),
            UsersModel("juandelacruz2",31,"juandelacruz2@gmail.com",0),
            UsersModel("juandelacruz3",32,"juandelacruz3@gmail.com",0),
            UsersModel("juandelacruz4",33,"juandelacruz4@gmail.com",0),
            UsersModel("juandelacruz5",34,"juandelacruz5@gmail.com",0),
            UsersModel("juandelacruz6",35,"juandelacruz6@gmail.com",0)
        )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val simpleRvAdapter = SimpleRVAdapter(nameList)
        binding.rvSimpleName.layoutManager = layoutManager
        binding.rvSimpleName.adapter = simpleRvAdapter

    }
}