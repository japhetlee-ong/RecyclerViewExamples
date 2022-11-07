package com.auf.cea.recyclerviewexamples.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.adapters.InfiniteRVAdapter
import com.auf.cea.recyclerviewexamples.databinding.ActivityInfiniteScrollRecyclerViewBinding
import com.auf.cea.recyclerviewexamples.models.CounterModel

class InfiniteScrollRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfiniteScrollRecyclerViewBinding
    private lateinit var counterList : ArrayList<CounterModel>
    private lateinit var adapter : InfiniteRVAdapter
    private var isLoading: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfiniteScrollRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterList = arrayListOf(
            CounterModel(1),
            CounterModel(2),
            CounterModel(3),
            CounterModel(4),
            CounterModel(5)
        )

        adapter = InfiniteRVAdapter(counterList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvInfinite.adapter = adapter
        binding.rvInfinite.layoutManager = layoutManager

        binding.llProgressBar.visibility = View.GONE
        binding.rvInfinite.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE){
                    if(!isLoading){
                        isLoading = true
                        binding.llProgressBar.visibility = View.VISIBLE
                        getMoreData()
                    }
                }

            }
        })

    }

    private fun getMoreData(){
        val addNewData = ArrayList<CounterModel>()
        for (x in 1..5 ){
            addNewData.add(CounterModel(counterList.size + x))
        }

        object : CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                binding.llProgressBar.visibility = View.GONE
                isLoading = false
                adapter.addNewItems(addNewData)
            }
        }.start()

    }
}