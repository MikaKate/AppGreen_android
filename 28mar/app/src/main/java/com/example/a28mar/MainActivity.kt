package it.lafeltrinelli.listadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.lafeltrinelli.listadapter.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayList<Product>()

        for(n in 1..20){
            val product = Product("Prodotto $n", (n * 2).toFloat())
            products.add(product)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val productAdapter = ProductAdapter(products)
        recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        productAdapter.setOnCallback(object : ProductAdapter.AdapterCallback{
            override fun selectItem(position: Int) {
                Log.d("LogAdapter", "Product: $position")
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(intent)
            }

            override fun deleteItem(position: Int) {
                products.removeAt(position)
                productAdapter.notifyItemRemoved(position)
            }
        })

    }
}