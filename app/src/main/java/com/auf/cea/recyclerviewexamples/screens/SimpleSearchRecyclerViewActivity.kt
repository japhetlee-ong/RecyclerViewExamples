package com.auf.cea.recyclerviewexamples.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.adapters.SearchRVAdapter
import com.auf.cea.recyclerviewexamples.databinding.ActivitySimpleSearchRecyclerViewBinding
import com.auf.cea.recyclerviewexamples.models.FruitsModel

class SimpleSearchRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleSearchRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleSearchRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruitList = arrayListOf(
            FruitsModel("Mango","Mangifera indica"),
            FruitsModel("Apple","Pyrus malus"),
            FruitsModel("Pomegranate", "Punica granatum"),
            FruitsModel("Pineapple", "Ananus sativus"),
            FruitsModel("Orange", "Citrus aurantium"),
            FruitsModel("Strawberry", "Fragaria × ananassa"),
            FruitsModel("Sweet Potato", "Ipomoea batatas"),
            FruitsModel("Watermelon", "Citrullus lanatus")
        )

        val adapter = SearchRVAdapter(fruitList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvSearchable.adapter = adapter
        binding.rvSearchable.layoutManager = layoutManager

        binding.edtSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.getFilter().filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.getFilter().filter(newText)
                return true
            }

        })
    }
}