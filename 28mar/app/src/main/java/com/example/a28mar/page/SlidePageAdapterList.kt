package com.example.a28mar.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a28mar.page.list.ListRecentFragment

class SlidePageAdapterList (fa: FragmentActivity): FragmentStateAdapter(fa)  {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0) ListRecentFragment() else ProfileFragment()
    }
}