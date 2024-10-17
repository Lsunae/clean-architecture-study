package com.example.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSearchBinding
import com.example.presentation.ui.adapter.BookRvAdapter
import com.example.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()
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
        setBookList()
    }

    private fun setupView() {
        binding.apply {
            incTitle.tvTitle.text = getString(R.string.search)
            ivSearch.setOnClickListener {
                val query = etSearch.text.toString()
                if (query.isNotEmpty()) viewModel.getSearchList(query, 10)
            }
        }
    }

    private fun setAdapter() {
        bookAdapter = BookRvAdapter()
        binding.rvBook.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookAdapter
        }
    }

    private fun setBookList() {
        viewModel.searchList.observe(viewLifecycleOwner) {
            it?.let { item -> bookAdapter.addItems(item) }
            binding.llSearchEmpty.isVisible = it.isNullOrEmpty()
            binding.rvBook.isVisible = !it.isNullOrEmpty()
        }
    }
}