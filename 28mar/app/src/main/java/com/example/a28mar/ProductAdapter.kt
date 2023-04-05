package com.example.a28mar

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a28mar.model.Product

//componente di android che vuole in ingresso: qual’è la grafica della singola riga/cella, l’array di oggetti
//prende e cicla l’array, disegnandola graficamente
class ProductAdapter (private val products: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.CustomViewHolder>() {

    class CustomViewHolder(val view: ViewGroup)
        : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_product, parent, false) as ViewGroup
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val product = products[position]

        val titleText = holder.view.findViewById<TextView>(R.id.titleText)
        titleText.text = product.name

        val priceText = holder.view.findViewById<TextView>(R.id.priceText)
        priceText.text = product.getPriceString()


        holder.view.setOnClickListener {
            /*val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("name", product.name)
            context.startActivity(intent)*/
            mListener?.selectItem(position)
        }
        holder.view.setOnLongClickListener{
            //mListener?.deleteItem(position)
            products.removeAt(position)
            notifyDataSetChanged()
            //notifyItemRemoved(position)
            true
        }
    }

    override fun getItemCount() = products.size

    /*
     *
     *       Callback
     *
     * */
    interface AdapterCallback {
        fun selectItem(position: Int)
        fun deleteItem(position: Int)
    }
    private var mListener: AdapterCallback? = null

    fun setOnCallback(mItemClickListener: AdapterCallback) {
        this.mListener = mItemClickListener
    }
}