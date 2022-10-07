package com.example.recipeapp.fragments

import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.recipeapp.ui.recipe.RegionSelectFragment
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Tests for the region select fragent
 */
@RunWith(MockitoJUnitRunner::class)
class RegionSelectFragmentTest {

    @Mock
    private lateinit var view : View

    @Mock
    lateinit var supportFragmentManager : FragmentManager

    /**
     * Test the toString method
     */
    @Test
    fun testToString() {
        val regionSelectFragment = RegionSelectFragment(supportFragmentManager)
        assertEquals(regionSelectFragment.toString(), "Select a Continent")
    }
}