package com.example.a28mar.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.a28mar.R
import com.google.android.material.tabs.TabLayout


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    //GESTIONE TABS
    /*val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
    val viewPager = findViewById<ViewPager2>(R.id.viewPager)
    val adapter = SlidePageAdapter(this)

    viewPager.adapter = adapter
    TabLayoutMediator(tabLayout, viewPager){ tab, position ->
        tab.text = "Label ${position+1}"

    }.attach()*/
}