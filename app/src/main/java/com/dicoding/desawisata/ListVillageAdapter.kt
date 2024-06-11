package com.dicoding.desawisata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.desawisata.databinding.ItemRowVillageBinding

class ListVillageAdapter(private val listVillage: ArrayList<Village>) :
    RecyclerView.Adapter<ListVillageAdapter.ListViewHolder>() {
    // Variabel untuk lambda
    var onItemClick: ((Village) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemRowVillageBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, description, location, uniqueDetails) = listVillage[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            // Memanggil lambda dengan data Village yang dipilih oleh user
            onItemClick?.invoke(listVillage[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listVillage.size

    class ListViewHolder(var binding: ItemRowVillageBinding) : RecyclerView.ViewHolder(binding.root)
}
