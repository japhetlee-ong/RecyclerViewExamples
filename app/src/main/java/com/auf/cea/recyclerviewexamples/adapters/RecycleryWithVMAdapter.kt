package com.auf.cea.recyclerviewexamples.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.databinding.ContentRecyclerViewmodelBinding
import com.auf.cea.recyclerviewexamples.models.VeggiesModel

class RecycleryWithVMAdapter(private var veggieList:List<VeggiesModel>): RecyclerView.Adapter<RecycleryWithVMAdapter.RecyclerWithVMViewHolder>() {

    inner class RecyclerWithVMViewHolder(val binding: ContentRecyclerViewmodelBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerWithVMViewHolder {
        val binding = ContentRecyclerViewmodelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyclerWithVMViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return veggieList.size
    }

    override fun onBindViewHolder(holder: RecyclerWithVMViewHolder, position: Int) {
        with(holder){
            with(veggieList[position]){
                binding.txtName.text = this.name
                binding.txtScientificName.text = this.scientificName
            }
        }
    }

}