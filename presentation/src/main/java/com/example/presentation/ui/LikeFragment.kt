package com.example.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.databinding.FragmentLikeBinding
import com.example.presentation.ui.adapter.BookRvAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : Fragment() {
    private lateinit var binding: FragmentLikeBinding
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
    }

    private fun setupView() {
        binding.apply {
            incTitle.tvTitle.text = getString(R.string.like)
        }
    }

    private fun setAdapter() {
        bookAdapter = BookRvAdapter()
        binding.rvBook.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookAdapter
        }
    }
}