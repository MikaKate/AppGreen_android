package com.example.a28mar.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SlidePageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {

        when(position){
            0 -> ListFragment()
            1 -> ProductFragment()
            2 -> ForYouFragment()
            3 -> ProfileFragment()
        }

        /*return if(position == 0) PageFragment() else SecondFragment()*/
    }
}