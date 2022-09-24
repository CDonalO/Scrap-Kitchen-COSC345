package com.example.recipeapp.ui.shoppingList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.db.entities.ShoppingItemEnt
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.floor

/**
 * Adapter for the [RecyclerView] in [ShoppingList].
 */
class ShoppingListItemAdapter(private val shoppingList: List<ShoppingItemEnt>, private val vm:ShoppingListViewModel) : RecyclerView.Adapter<ShoppingListItemAdapter.MyViewHolder>() {
    /**
     * Inner class for creating ViewHolders.
     */
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view),View.OnClickListener{
        init {
            view.findViewById<CheckBox>(R.id.s_got).setOnClickListener(this)
            println(shoppingList)
        }
        val name: TextView = view.findViewById<TextView>(R.id.slist_name)
        val metric: TextView = view.findViewById<TextView>(R.id.slist_amount_metric)
        val checkbox : CheckBox = view.findViewById<CheckBox>(R.id.s_got)
        override fun onClick(view: View){
            GlobalScope.launch {
                val item = shoppingList[adapterPosition]
                vm.checkItem(item)
            }
        }
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_rv,parent,false)
        return MyViewHolder(binding)
    }
    /**
     * Gets item count
     */
    override fun getItemCount(): Int {
        return shoppingList.size
    }
    /**
     * Gets items
     */
    fun getItems() : List<ShoppingItemEnt>{
        return shoppingList
    }
    /**
     * Deletes item in db
     */
    fun deleteItem(i : Int){
        vm.removeItem(shoppingList[i])
    }
    /**
     * Binds the view holder to the data
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.name.text = item.item
        holder.checkbox.setChecked(item.checked)
        var amount = item.amount.toString()
        if (item.amount.toDouble() == floor(item.amount.toDouble())){
            amount = item.amount.toInt().toString()
        }
        holder.metric.text = amount + " "+ item.metric


    }
}