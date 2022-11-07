package com.auf.cea.recyclerviewexamples.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.databinding.ContentSearchRvBinding
import com.auf.cea.recyclerviewexamples.models.FruitsModel
import java.util.*
import kotlin.collections.ArrayList

class SearchRVAdapter(private var fruitList:ArrayList<FruitsModel>): RecyclerView.Adapter<SearchRVAdapter.SearchRVViewHolder>() {

    val initialFruitList = ArrayList<FruitsModel>().apply {
        addAll(fruitList)
    }

    inner class SearchRVViewHolder(val binding: ContentSearchRvBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(binding: ContentSearchRvBinding){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRVViewHolder {
        val binding = ContentSearchRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchRVViewHolder, position: Int) {
        with(holder){
            holder.bind(holder.binding)
            with(fruitList[position]){
                binding.txtName.text = this.name
                binding.txtScientificName.text = this.scientificName
            }
        }
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    fun getFilter(): Filter {
        return fruitFilter
    }

    private val fruitFilter = object : Filter() {
        override fun performFiltering(constraint : CharSequence?): FilterResults{
            val filteredList: ArrayList<FruitsModel> = ArrayList()
            if(constraint == null || constraint.isEmpty()){
                initialFruitList.let { filteredList.addAll(it) }
                //fruitList.let { filteredList.addAll(it) }
            }else{
                val query = constraint.toString().trim().lowercase()
                initialFruitList.forEach {
                    if(it.name.lowercase(Locale.ROOT).contains(query)){
                        filteredList.add(it)
                    }
                }
            }

            val results = FilterResults()
            results.values = filteredList
            return results
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            if(p1?.values is ArrayList<*>){
                fruitList.clear()
                fruitList.addAll(p1.values as ArrayList<FruitsModel>)
                notifyDataSetChanged()
            }
        }

    }
}