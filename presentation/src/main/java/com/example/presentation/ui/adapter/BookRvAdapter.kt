package com.example.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Book
import com.example.presentation.R
import com.example.presentation.databinding.ItemBookBinding
import com.example.presentation.ui.SearchFragment
import com.example.presentation.util.ClickListener
import com.example.presentation.util.TabType
import com.example.presentation.util.glideImageSet
import java.lang.ref.WeakReference

class BookRvAdapter(private var tabType: TabType) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var context: Context
    private var items = mutableListOf<Book>()
    private lateinit var onLikeClickListener: ClickListener
    lateinit var searchFragment: WeakReference<SearchFragment>
    private var currentRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        currentRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        currentRecyclerView = null
    }

    fun addItems(items: MutableList<Book>) {
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

    fun setLikeStatus(isSelected: Boolean, position: Int) {
        if (currentRecyclerView != null) {
            val holder: RecyclerView.ViewHolder? =
                currentRecyclerView!!.findViewHolderForAdapterPosition(position)
            if (holder is Holder) holder.setLikeStatus(isSelected)
        }
    }

    fun setOnLikeClickListener(listener: ClickListener) {
        this.onLikeClickListener = listener
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
                holder.bind(items[position], position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class Holder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book, position: Int) {
            binding.apply {
                if (!item.image.isNullOrEmpty()) ivBook.glideImageSet(item.image!!)
                else ivBook.setImageResource(R.drawable.ic_error)

                tvTitle.text = item.title
                tvAuthor.text = item.author

                if (tabType == TabType.LIKE) {
                    ivLike.isSelected = true
                } else {
                    ivLike.isSelected =
                        searchFragment.get() != null && !searchFragment.get()!!.getLikeList()
                            .isNullOrEmpty() && searchFragment.get()!!.getLikeList()!!
                            .contains(item)
                }

                ivLike.setOnClickListener {
                    ivLike.isSelected = !ivLike.isSelected
                    onLikeClickListener.onLikeClick(
                        Book(
                            item.title,
                            item.link,
                            item.image,
                            item.author
                        ),
                        ivLike.isSelected,
                        position
                    )
                }
            }
        }

        fun setLikeStatus(isSelected: Boolean) {
            binding.ivLike.isSelected = isSelected
        }
    }
}