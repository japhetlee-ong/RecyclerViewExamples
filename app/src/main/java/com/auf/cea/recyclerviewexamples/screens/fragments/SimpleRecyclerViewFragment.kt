package com.auf.cea.recyclerviewexamples.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.R
import com.auf.cea.recyclerviewexamples.adapters.SimpleRVAdapter
import com.auf.cea.recyclerviewexamples.databinding.FragmentSimpleRecyclerViewBinding
import com.auf.cea.recyclerviewexamples.models.UsersModel

class SimpleRecyclerViewFragment : Fragment() {
    private lateinit var binding: FragmentSimpleRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSimpleRecyclerViewBinding.inflate(inflater,container,false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameList = arrayListOf(
            UsersModel("juandelacruz",30,"juandelacruz@gmail.com",0),
            UsersModel("juandelacruz2",31,"juandelacruz2@gmail.com",0),
            UsersModel("juandelacruz3",32,"juandelacruz3@gmail.com",0),
            UsersModel("juandelacruz4",33,"juandelacruz4@gmail.com",0),
            UsersModel("juandelacruz5",34,"juandelacruz5@gmail.com",0),
            UsersModel("juandelacruz6",35,"juandelacruz6@gmail.com",0)
        )
        val adapter = SimpleRVAdapter(nameList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvFragSimple.adapter = adapter
        binding.rvFragSimple.layoutManager = layoutManager
    }
}