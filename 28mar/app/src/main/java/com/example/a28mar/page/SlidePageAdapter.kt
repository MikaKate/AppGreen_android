package com.example.a28mar.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SlidePageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {

        return if(position == 0) ListFragment() else if(position == 1) ProductFragment() else if(position == 2)  ForYouFragment() else ProfileFragment()
    }
}