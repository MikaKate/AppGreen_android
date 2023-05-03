package com.example.a28mar.page.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.a28mar.R
import com.example.a28mar.page.SlidePageAdapterList
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.a28mar.model.Product
import androidx.recyclerview.widget.RecyclerView
import com.example.a28mar.DetailActivity
import com.example.a28mar.ProductAdapter

class ListRecentFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_recent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val products = ArrayList<Product>() //Dichiarazione di un array di stringhe VUOTO

        for(n in 1..5){
            val product = Product("Prodotto $n", (n * 2).toFloat()) //alla classe Product vengono passati in input la stringa e il valore decimale
            products.add(product) //alla lista vuota products viene aggiunto l'elemento creato
        }

       val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView) //dal file main.xml cerca l'oggetto con id recyclerView

        val productAdapter = ProductAdapter(products)
        recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }
        productAdapter.setOnCallback(object : ProductAdapter.AdapterCallback{
            override fun selectItem(position: Int) {
                Log.d("LogAdapter", "Product: $position")
                val intent = Intent(requireActivity(), DetailActivity::class.java)
                intent.putExtra("name", products[position].name)
                startActivity(intent)
            }

            override fun deleteItem(position: Int) {
                products.removeAt(position)
                productAdapter.notifyItemRemoved(position)
            }
        })
    }
}