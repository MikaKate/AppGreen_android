package com.example.a28mar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a28mar.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //vedi appunti

        val products = ArrayList<Product>() //Dichiarazione di un array di stringhe VUOTO

        for(n in 1..5){
            val product = Product("Prodotto $n", (n * 2).toFloat()) //alla classe Product vengono passati in input la stringa e il valore decimale
            products.add(product) //alla lista vuota products viene aggiunto l'elemento creato
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) //dal file main.xml cerca l'oggetto con id recyclerView

        val productAdapter = ProductAdapter(products)
        recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        productAdapter.setOnCallback(object : ProductAdapter.AdapterCallback{
            override fun selectItem(position: Int) {
                Log.d("LogAdapter", "Product: $position")
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
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