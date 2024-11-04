package com.example.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Book
import com.example.presentation.R
import com.example.presentation.databinding.FragmentLikeBinding
import com.example.presentation.ui.adapter.BookRvAdapter
import com.example.presentation.util.ClickListener
import com.example.presentation.util.TabType
import com.example.presentation.viewmodel.LikeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : Fragment() {
    private lateinit var binding: FragmentLikeBinding
    private val likeViewModel: LikeViewModel by viewModels()
    private lateinit var bookAdapter: BookRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setAdapter()
        setClickListener()

        getLikeList()
        likeViewModel.getLikeList()
    }

    private fun setupView() {
        binding.apply {
            incTitle.tvTitle.text = getString(R.string.like)
        }
    }

    private fun setAdapter() {
        bookAdapter = BookRvAdapter(TabType.LIKE)
        binding.rvBook.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookAdapter
        }
    }

    private fun setClickListener() {
        bookAdapter.setOnClickListener(object : ClickListener {
            override fun onItemClick(item: Book) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                startActivity(intent)
            }

            override fun onLikeClick(item: Book, isSelected: Boolean, position: Int) {
                likeViewModel.setLike(item, isSelected) { isSuccess ->
                    if (isSuccess) {
                        val message = if (isSelected) R.string.like_add else R.string.like_delete
                        Toast.makeText(
                            requireContext(),
                            resources.getString(message),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        bookAdapter.setLikeStatus(!isSelected, position)
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.like_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
    }

    private fun getLikeList() {
        likeViewModel.likeList.observe(viewLifecycleOwner) {
            it?.let { item -> bookAdapter.addItems(item) }
            binding.llLikeEmpty.isVisible = it.isNullOrEmpty()
            binding.rvBook.isVisible = !it.isNullOrEmpty()
        }
    }
}