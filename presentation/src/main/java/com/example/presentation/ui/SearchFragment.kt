package com.example.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
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
import com.example.presentation.databinding.FragmentSearchBinding
import com.example.presentation.ui.adapter.BookRvAdapter
import com.example.presentation.util.ClickListener
import com.example.presentation.util.TabType
import com.example.presentation.util.hideKeyboard
import com.example.presentation.viewmodel.LikeViewModel
import com.example.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()
    private val likeViewModel: LikeViewModel by viewModels()
    private lateinit var bookAdapter: BookRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setAdapter()

        bookAdapter.searchFragment = WeakReference(this)

        setClickListener()
        setBookList()

        likeViewModel.getLikeList()
    }

    private fun setupView() {
        binding.apply {
            incTitle.tvTitle.text = getString(R.string.search)
            ivSearch.setOnClickListener {
                searchBook()
            }
            etSearch.setOnKeyListener { v, keyCode, event ->
                if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    searchBook()
                }
                false
            }
        }
    }

    private fun setAdapter() {
        bookAdapter = BookRvAdapter(TabType.SEARCH)
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

    private fun searchBook() {
        val query = binding.etSearch.text.toString()
        if (query.isNotEmpty()) searchViewModel.getSearchList(query, 10)
        binding.etSearch.hideKeyboard(requireContext())
    }

    private fun setBookList() {
        searchViewModel.searchList.observe(viewLifecycleOwner) {
            it?.let { items -> bookAdapter.addItems(items) }
            binding.llSearchEmpty.isVisible = it.isNullOrEmpty()
            binding.rvBook.isVisible = !it.isNullOrEmpty()
        }
    }

    fun getLikeList(): MutableList<Book>? {
        return likeViewModel.likeList.value
    }
}