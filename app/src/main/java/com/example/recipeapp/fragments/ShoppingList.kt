package com.example.recipeapp.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.AppDB
import com.example.recipeapp.ListAdapter
import com.example.recipeapp.R
import com.example.recipeapp.SItemAdapter
import com.example.recipeapp.activities.AddShoppingItem
import com.example.recipeapp.entities.RecipeEnt
import com.example.recipeapp.entities.ShoppingItemEnt

class ShoppingList:Fragment(R.layout.fragment_shopping_list) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SItemAdapter
    private lateinit var items : List<ShoppingItemEnt>
    private lateinit var db : AppDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_item,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_add_item -> {
                var intent: Intent = Intent(requireActivity(), AddShoppingItem::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDB.getInstance(view.context)
        items = db.shoppingItemDAO().getShoppingList()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.shoppingListRecycle)
        recyclerView.layoutManager = layoutManager
        adapter = SItemAdapter(items)
        recyclerView.adapter = adapter
    }



    override fun onResume() {
        items = db.shoppingItemDAO().getShoppingList()
        adapter = SItemAdapter(items)
        recyclerView.adapter = adapter
        super.onResume()
    }

}