package com.auf.cea.recyclerviewexamples.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.adapters.TwoViewsRVAdapter
import com.auf.cea.recyclerviewexamples.databinding.ActivityTwoViewsRecyclerViewBinding
import com.auf.cea.recyclerviewexamples.models.UsersModel

class TwoViewsRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoViewsRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoViewsRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameList = arrayListOf(
            UsersModel("juandelacruz",30,"juandelacruz@gmail.com",0),
            UsersModel("juandelacruz2",31,"juandelacruz2@gmail.com",1,"123 somewhere rd, PH"),
            UsersModel("juandelacruz3",32,"juandelacruz3@gmail.com",0),
            UsersModel("juandelacruz4",33,"juandelacruz4@gmail.com",1, "456 somewhere rd, PH"),
            UsersModel("juandelacruz5",34,"juandelacruz5@gmail.com",0),
            UsersModel("juandelacruz6",35,"juandelacruz6@gmail.com",1, "789 somewhere rd, PH")
        )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val twoViewRvAdaper = TwoViewsRVAdapter(nameList)
        binding.rvTwoView.layoutManager = layoutManager
        binding.rvTwoView.adapter = twoViewRvAdaper

    }
}