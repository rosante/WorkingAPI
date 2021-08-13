package com.ruzzante.workingapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val context: Context, private val productList:List<Product>) : RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder = ProductViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.productName.text = item.prname
        holder.productId.text = item.id
        holder.productPrice.text = item.prprice
        Glide.with(context).load(item.primage).into(holder.productImage)
    }

    override fun getItemCount() = productList.size

}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productImage: ImageView = itemView.findViewById(R.id.img_product_image)
    val productId: TextView = itemView.findViewById(R.id.tv_product_id)
    val productName: TextView = itemView.findViewById(R.id.tv_product_name)
    val productPrice: TextView = itemView.findViewById(R.id.tv_product_price)
}