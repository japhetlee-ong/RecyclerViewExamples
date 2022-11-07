package com.auf.cea.recyclerviewexamples.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.databinding.ContentInfiniteRvBinding
import com.auf.cea.recyclerviewexamples.models.CounterModel

class InfiniteRVAdapter(private var counterList: ArrayList<CounterModel>): RecyclerView.Adapter<InfiniteRVAdapter.InfiniteRVViewHolder>(){

    inner class InfiniteRVViewHolder(val binding: ContentInfiniteRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(binding: ContentInfiniteRvBinding){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfiniteRVViewHolder {
        val binding = ContentInfiniteRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return InfiniteRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InfiniteRVViewHolder, position: Int) {
        with(holder){
            holder.bind(holder.binding)
            with(counterList[position]){
                binding.txtCount.text = this.counter.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return counterList.size
    }

    fun addNewItems(items: ArrayList<CounterModel>){
        counterList.addAll(items)
        notifyItemInserted(counterList.size)
    }
}
