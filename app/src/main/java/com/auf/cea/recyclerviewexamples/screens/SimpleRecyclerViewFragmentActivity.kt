package com.auf.cea.recyclerviewexamples.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.databinding.ActivitySimpleRecyclerViewFragmentBinding
import com.auf.cea.recyclerviewexamples.screens.fragments.SimpleRecyclerViewFragment

class SimpleRecyclerViewFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragContainer.id,SimpleRecyclerViewFragment())
        fragmentManager.commit()
    }
}