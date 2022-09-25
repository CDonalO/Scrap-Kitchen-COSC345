package com.example.recipeapp.ui.mealPlanner

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.recipeapp.db.AppDB
import com.example.recipeapp.db.entities.MealPlannerEnt
import com.example.recipeapp.db.entities.RecipeEnt
import com.example.recipeapp.db.repos.MealPlannerRepo


class MealPlannerViewModel(private val repo: MealPlannerRepo) : ViewModel() {
    var items: LiveData<List<MealPlannerEnt>> = repo.getMealPlanner().asLiveData()
    var weekRecipes : MutableList<RecipeEnt> = mutableListOf()

    fun updateMealItem(recipeId: Int,index:Int){
        repo.updateMealPlanner(recipeId, index)
    }
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val repo = MealPlannerRepo(AppDB.getInstance(application.applicationContext).mealPlannerDAO())
                val savedStateHandle = extras.createSavedStateHandle()

                return MealPlannerViewModel(
                    (repo as MealPlannerRepo)
                ) as T
            }
        }
    }
}