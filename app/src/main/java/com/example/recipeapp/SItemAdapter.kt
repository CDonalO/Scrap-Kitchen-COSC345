package com.example.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.entities.ShoppingItemEnt
import com.example.recipeapp.fragments.ShoppingList

class SItemAdapter(private var shoppingList: List<ShoppingItemEnt>,private val listener: ShoppingList) : RecyclerView.Adapter<SItemAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View, private val onClickListener: ShoppingList): RecyclerView.ViewHolder(view),View.OnClickListener{
        init {
            if(view.findViewById<CheckBox>(R.id.s_got)!=null){
                view.findViewById<CheckBox>(R.id.s_got).setOnClickListener(this)
            }
        }
        val name: TextView = view.findViewById(R.id.slist_name)
        val metric: TextView = view.findViewById(R.id.slist_amount_metric)
        override fun onClick(view: View){
            val item = shoppingList[adapterPosition]
            listener.onItemCheck(item)
        }
    }

    interface OnItemCheckListener {
        fun onItemCheck(item: ShoppingItemEnt)
        fun onItemSwipe(item: ShoppingItemEnt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list_rv,parent,false)
        return MyViewHolder(binding,listener)
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    fun deleteItem(i : Int){
        listener.onItemSwipe(shoppingList[i])
        shoppingList = if(shoppingList.isNotEmpty()){
            shoppingList.slice(0 until i) + shoppingList.slice(i+1 until shoppingList.size)
        } else{
            emptyList()
        }
    }

    companion object {
        fun generateText(metric: String, amount: Int): String {
            return if (metric == "Whole") {
                "$amount $metric"
            } else {
                "$amount$metric"
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.name.text = item.item
        holder.metric.text = generateText(item.metric,item.amount)
        }

    }