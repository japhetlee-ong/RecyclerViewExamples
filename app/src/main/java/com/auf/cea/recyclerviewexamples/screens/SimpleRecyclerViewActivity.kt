package com.auf.cea.recyclerviewexamples.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.auf.cea.recyclerviewexamples.adapters.SimpleRVAdapter
import com.auf.cea.recyclerviewexamples.databinding.ActivitySimpleRecyclerViewBinding
import com.auf.cea.recyclerviewexamples.models.UsersModel
import com.google.android.material.snackbar.Snackbar


class SimpleRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerViewBinding
    private lateinit var nameList: ArrayList<UsersModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        nameList = arrayListOf(
            UsersModel("juandelacruz",30,"juandelacruz@gmail.com",0),
            UsersModel("juandelacruz2",31,"juandelacruz2@gmail.com",0),
            UsersModel("juandelacruz3",32,"juandelacruz3@gmail.com",0),
            UsersModel("juandelacruz4",33,"juandelacruz4@gmail.com",0),
            UsersModel("juandelacruz5",34,"juandelacruz5@gmail.com",0),
            UsersModel("juandelacruz6",35,"juandelacruz6@gmail.com",0)
        )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val simpleRvAdapter = SimpleRVAdapter(nameList)
        binding.rvSimpleName.layoutManager = layoutManager
        binding.rvSimpleName.adapter = simpleRvAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                // this method is called
                // when the item is moved.
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // this method is called when we swipe our item to right direction.
                // on below line we are getting the item at a particular position.
                val deletedName: UsersModel = nameList[viewHolder.adapterPosition]

                // below line is to get the position
                // of the item at that position.
                val position = viewHolder.adapterPosition

                // this method is called when item is swiped.
                // below line is to remove item from our array list.
                nameList.removeAt(viewHolder.adapterPosition)

                // below line is to notify our item is removed from adapter.
                simpleRvAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                // below line is to display our snackbar with action.
                Snackbar.make(binding.rvSimpleName, deletedName.username, Snackbar.LENGTH_LONG)
                    .setAction("Undo",
                        View.OnClickListener { // adding on click listener to our action of snack bar.
                            // below line is to add our item to array list with a position.
                            nameList.add(position, deletedName)

                            // below line is to notify item is
                            // added to our adapter class.
                            simpleRvAdapter.notifyItemInserted(position)
                        }).show()
            } // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(binding.rvSimpleName)

    }
}