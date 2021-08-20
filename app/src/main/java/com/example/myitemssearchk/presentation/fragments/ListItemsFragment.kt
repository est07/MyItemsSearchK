package com.example.myitemssearchk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myitemssearchk.R
import com.example.myitemssearchk.databinding.FragmentListItemsBinding
import com.example.myitemssearchk.databinding.FragmentSearchBinding
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.presentation.adapter.ListItemsAdapter

class ListItemsFragment : Fragment(R.layout.fragment_list_items) {

    private val adapter = ListItemsAdapter(listOf()) {
        Toast.makeText(this.context, "show data", Toast.LENGTH_SHORT).show()
    }

    private lateinit var binding: FragmentListItemsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListItemsBinding.bind(view)
        initView()
    }

    private fun initView() {
        binding.apply {
            rvItemSearchList.layoutManager = LinearLayoutManager(context)
            rvItemSearchList.adapter = adapter
        }
    }

    private fun showItems(items: List<ItemSearch>) {
        adapter.data = items
    }
}
