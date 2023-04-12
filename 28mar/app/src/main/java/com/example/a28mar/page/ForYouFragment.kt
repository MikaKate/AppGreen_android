package com.example.a28mar.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a28mar.R


/**
 * A simple [Fragment] subclass.
 * Use the [ForYouFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForYouFragment : Fragment() {
    class ListFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_for_you, container, false)
        }
    }
}