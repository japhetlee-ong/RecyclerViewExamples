package com.auf.cea.recyclerviewexamples.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.adapters.RecycleryWithVMAdapter
import com.auf.cea.recyclerviewexamples.databinding.ActivityRecyclerviewWithViewModelBinding
import com.auf.cea.recyclerviewexamples.models.VeggiesModel
import com.auf.cea.recyclerviewexamples.models.viewmodels.VeggieViewModel

class RecyclerviewWithViewModelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecyclerviewWithViewModelBinding
    private lateinit var data : List<VeggiesModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewWithViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.rvVeggies.layoutManager = layoutManager

        val veggiesViewModel = ViewModelProvider(this)[VeggieViewModel::class.java]
        veggiesViewModel.getVeggiesList().observe(this) { veggieList ->
            data = veggieList

            val recyclerviewWithVMAdapter = RecycleryWithVMAdapter(data)
            binding.rvVeggies.adapter = recyclerviewWithVMAdapter

        }

    }
}