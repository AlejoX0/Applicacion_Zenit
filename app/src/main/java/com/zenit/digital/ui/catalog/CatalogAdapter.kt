package com.zenit.digital.ui.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.zenit.digital.databinding.ItemCatalogProductBinding

data class Product(
    val title: String,
    val description: String,
    val price: String,
    @get:DrawableRes val imageResId: Int
)

class CatalogAdapter(private val products: List<Product>) : RecyclerView.Adapter<CatalogAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemCatalogProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size

    inner class ProductViewHolder(private val binding: ItemCatalogProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productTitle.text = product.title
            binding.productDescription.text = product.description
            binding.productPrice.text = product.price
            binding.productImage.setImageResource(product.imageResId)
        }
    }
}