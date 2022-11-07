package com.auf.cea.recyclerviewexamples.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.databinding.ContentSimpleRvBinding
import com.auf.cea.recyclerviewexamples.models.UsersModel

class SimpleRVAdapter(private var nameList: ArrayList<UsersModel>) : RecyclerView.Adapter<SimpleRVAdapter.SimpleRVViewHolder>() {

    inner class SimpleRVViewHolder(val binding: ContentSimpleRvBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(binding: ContentSimpleRvBinding){
            binding.llCardView.setOnClickListener{
                val user = nameList[adapterPosition]
                Log.d(SimpleRVAdapter::class.simpleName, user.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRVViewHolder {
        val binding = ContentSimpleRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SimpleRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimpleRVViewHolder, position: Int) {
        with(holder){
            holder.bind(holder.binding)
            with(nameList[position]){
                binding.txtAge.text = this.age.toString()
                binding.txtName.text = this.username
                binding.txtEmail.text = this.email
            }
        }
    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}