package com.example.bankuixml


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bankuixml.databinding.ItemActivityBinding


class TransferAdapter : RecyclerView.Adapter<TransferAdapter.TransferAdapterViewHolder>() {
    var list: MutableList<TransferModel> = mutableListOf()
    var onClick: (TransferModel) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityBinding.inflate(layoutInflater, parent, false)
        return TransferAdapterViewHolder(binding, onClick)
    }


    override fun onBindViewHolder(holder: TransferAdapterViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int = list.size


    fun deleteItem(index: Int) {
        list.removeAt(index)
        notifyDataSetChanged()
    }


    class TransferAdapterViewHolder(
        private val binding: ItemActivityBinding,
        private val onClick: (TransferModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TransferModel) = with(binding) {
            NameItem.text = item.name
            Glide.with(binding.root).load(item.avatar).into(avatar)
        }
    }
}