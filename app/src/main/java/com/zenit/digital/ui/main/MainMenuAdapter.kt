package com.zenit.digital.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.zenit.digital.databinding.ItemMainMenuBinding

data class MenuItem(val title: String, val navigationActionId: Int)

class MainMenuAdapter(private val menuItems: List<MenuItem>) : RecyclerView.Adapter<MainMenuAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(menuItems[position])
    }

    override fun getItemCount() = menuItems.size

    inner class MainViewHolder(private val binding: ItemMainMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItem: MenuItem) {
            binding.menuItemTitle.text = menuItem.title
            binding.root.setOnClickListener {
                it.findNavController().navigate(menuItem.navigationActionId)
            }
        }
    }
}