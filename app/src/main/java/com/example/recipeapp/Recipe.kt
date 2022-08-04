package com.example.recipeapp

import android.content.ClipData.newIntent
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.entities.RecipeEnt

class Recipe:Fragment(), ListAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipes : List<RecipeEnt>

    /**
     * This method is called when the fragment is created.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)
        val adapter = ListAdapter(this)
        //Get a reference to the recycler view in the recipe fragment
        recyclerView = view.findViewById(R.id.recipeRecycler)
        //Set the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        //Try reading the data from the database
        recipes = AppDB.getInstance(view.context).recipeDAO().getRecipes()
        adapter.setRecipeList(recipes)
        //Set the adapter on the recycler view


        return view
    }

    override fun onItemClick(recipe: RecipeEnt) {

        val intent = Intent (context, RecipeDetailActivity()::class.java)
        intent.putExtra("recipe", recipe)
        startActivity(intent)
    }

    /**
     * Returns this instance as a string
     * Used to set the title of the view
     */
    override fun toString(): String {
        return "Recipeeees"
    }

}