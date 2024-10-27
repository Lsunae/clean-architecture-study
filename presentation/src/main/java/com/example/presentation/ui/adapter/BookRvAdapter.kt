package com.example.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Book
import com.example.presentation.R
import com.example.presentation.databinding.ItemBookBinding
import com.example.presentation.util.glideImageSet

class BookRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context: Context
    private var items = arrayListOf<Book>()

    fun addItems(items: ArrayList<Book>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun resetItems() {
        items.clear()
        notifyDataSetChanged()
    }

    fun notifyChange() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        this.context = parent.context
        return Holder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        settingPosition(holder, position)
    }

    private fun settingPosition(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Holder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class Holder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book) {
            binding.apply {
                if (!item.image.isNullOrEmpty()) ivBook.glideImageSet(item.image!!)
                else ivBook.setImageResource(R.drawable.ic_error)

                tvTitle.text = item.title
                tvAuthor.text = item.author
            }
        }
    }
}