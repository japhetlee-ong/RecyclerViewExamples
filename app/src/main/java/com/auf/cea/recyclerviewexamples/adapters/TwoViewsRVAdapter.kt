package com.auf.cea.recyclerviewexamples.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.databinding.ContentSimpleRvBinding
import com.auf.cea.recyclerviewexamples.databinding.ContentTypeTwoRvBinding
import com.auf.cea.recyclerviewexamples.models.UsersModel

private const val VIEW_TYPE_LEFT = 0
private const val VIEW_TYPE_RIGHT = 1

class TwoViewsRVAdapter(private val userList: List<UsersModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(private val leftBinding: ContentSimpleRvBinding) : RecyclerView.ViewHolder(leftBinding.root){
        fun bind(itemData : UsersModel){
            leftBinding.txtAge.text = itemData.age.toString()
            leftBinding.txtEmail.text = itemData.email
            leftBinding.txtName.text = itemData.username
        }
    }

    inner class RightViewHolder(private val rightBinding: ContentTypeTwoRvBinding) : RecyclerView.ViewHolder(rightBinding.root){
        fun bind(itemData: UsersModel){
            rightBinding.txtAge.text = itemData.age.toString()
            rightBinding.txtEmail.text = itemData.email
            rightBinding.txtName.text = itemData.username
            rightBinding.txtAddress.text = itemData.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LEFT -> {
                val binding = ContentSimpleRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                LeftViewHolder(binding)
            }
            VIEW_TYPE_RIGHT -> {
                val binding = ContentTypeTwoRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                RightViewHolder(binding)
            }
            else -> {
                val binding = ContentSimpleRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                LeftViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userData = userList[position]
        if(holder is LeftViewHolder){
            holder.bind(userData)
        }else if(holder is RightViewHolder){
            holder.bind(userData)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun getItemViewType(position: Int): Int {
        val userData = userList[position]
        return userData.type
    }

}