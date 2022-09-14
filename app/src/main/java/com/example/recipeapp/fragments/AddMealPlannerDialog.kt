package com.example.recipeapp.fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.recipeapp.R
import java.lang.IllegalStateException

class AddMealPlannerDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val alertBuilder1 = AlertDialog.Builder(it)
            var checkedItemDay = 0

            alertBuilder1.setTitle("Select a day")
            alertBuilder1.setSingleChoiceItems(R.array.day, 0, DialogInterface.OnClickListener { _, index ->
                checkedItemDay = index
            })
            alertBuilder1.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ -> Log.d("DialogLog",
                "Ok $checkedItemDay")})
            alertBuilder1.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ -> Log.d("DialogLog", "Cancelled") })




            alertBuilder1.create()

        } ?: throw IllegalStateException("Exception !! Activity is null !!")
    }
}