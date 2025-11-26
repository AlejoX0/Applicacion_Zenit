package com.zenit.digital.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.zenit.digital.databinding.ItemGalleryImageBinding

data class GalleryImage(@get:DrawableRes val imageResId: Int)

class GalleryAdapter(private val images: List<GalleryImage>) : RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemGalleryImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount() = images.size

    inner class ImageViewHolder(private val binding: ItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryImage: GalleryImage) {
            binding.galleryImage.setImageResource(galleryImage.imageResId)
        }
    }
}