package com.auf.cea.recyclerviewexamples.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInfiniteScroll.setOnClickListener(this)
        binding.btnRvWithSimpleSearch.setOnClickListener(this)
        binding.btnTwoViews.setOnClickListener(this)
        binding.btnSimpleRecyclerView.setOnClickListener(this)
        binding.btnSimpleRecyclerViewFragments.setOnClickListener(this)
        binding.btnRvVm.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btn_simple_recycler_view -> {
                val intent = Intent(this,SimpleRecyclerViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_simple_recycler_view_fragments -> {
                val intent = Intent(this,SimpleRecyclerViewFragmentActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_two_views -> {
                val intent = Intent(this,TwoViewsRecyclerViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_rv_with_simple_search ->{
                val intent = Intent(this,SimpleSearchRecyclerViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_infinite_scroll ->{
                val intent = Intent(this,InfiniteScrollRecyclerViewActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_rv_vm ->{
                val intent = Intent(this, RecyclerviewWithViewModelActivity::class.java)
                startActivity(intent)
            }
        }
    }
}