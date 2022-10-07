package com.example.recipeapp.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.recipeapp.R
import com.example.recipeapp.Util.Companion.stringToFormattedList
import com.example.recipeapp.consts.Emojis
import com.example.recipeapp.databinding.ActivityRecipeDetailBinding
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.ui.mealPlanner.MealPlannerSelectDialog

/**
 * @author Conor Griffiths
 */
class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var recipe: RecipeEnt
    private lateinit var binding : ActivityRecipeDetailBinding

    /**
     * onCreate method for the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipe = intent.getParcelableExtra("recipe")!!
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)

        val toolbar = binding.materialToolbar
        toolbar.title = recipe.name
        setSupportActionBar(toolbar)

        setContentView(binding.root)
        populateView()
    }

    /**
     * Populates the view with the recipe details
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recipe,menu)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * Handles the menu item clicks
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_meal_planner -> MealPlannerSelectDialog(recipe, applicationContext).show(supportFragmentManager, "AddMealPlannerDialog")
            R.id.action_shopping_list -> {
                val intent = Intent (applicationContext, AddFromRecipe()::class.java)
                intent.putExtra("recipe2", recipe)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Populate the view with the recipe data
     */
    private fun populateView() {
        val emojis = Emojis.Companion
        binding.flag.text = emojis.getEmoji(recipe.country)
        binding.titleTxt.text = recipe.name.replace("(","\n(")
        binding.descriptionTxt.text = recipe.description
        binding.ingredientsTxt.text = stringToFormattedList(recipe.ingredients)
        binding.methodTxt.text = stringToFormattedList(recipe.method)
        binding.servesTxt.text = "Serves ${recipe.servings}"
    }

}
