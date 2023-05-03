package com.example.a28mar.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.a28mar.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayoutList)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = SlidePageAdapterList(requireActivity())

        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            if(position ==0){
                tab.text = "Recent"
            }else{
                tab.text = "Categories"
            }
        }.attach()
    }
}