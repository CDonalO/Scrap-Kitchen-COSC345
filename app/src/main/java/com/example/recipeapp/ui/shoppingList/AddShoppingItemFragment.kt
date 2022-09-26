package com.example.recipeapp.ui.shoppingList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentAddShoppingItemBinding
import com.example.recipeapp.db.entities.ShoppingItemEnt

/**
 * Fragment to show a form to add a shopping item
 * @author Ariana,Conor,Cordell,Derek
 * */
class AddShoppingItemFragment : Fragment() {

    private val shoppingListViewModel: ShoppingListViewModel by activityViewModels { ShoppingListViewModel.Factory }
    private lateinit var binding: FragmentAddShoppingItemBinding

    /**
     * creates a binding and sets the on click listener
     * */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentAddShoppingItemBinding.inflate(inflater)
        binding = fragmentBinding
        binding.submit.setOnClickListener {
            addItem()
            requireActivity().onBackPressed()
        }
        return fragmentBinding.root
    }

    private fun addItem() {
        val name = view?.findViewById<EditText>(R.id.name)?.text.toString()
        val category = view?.findViewById<Spinner>(R.id.category)?.selectedItem.toString()
        val metric = view?.findViewById<Spinner>(R.id.metric)?.selectedItem.toString()
        val amount = view?.findViewById<EditText>(R.id.amount)?.text.toString()
        val ent = ShoppingItemEnt(0, name, amount.toDouble(), metric, true, category)
        shoppingListViewModel.mergeItems(listOf(ent))
//        shoppingListViewModel.addItem(ent)
    }

}