package com.example.myitemssearchk.presentation.fragments

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myitemssearchk.R
import com.example.myitemssearchk.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        initListener()
    }

    private fun initListener() {
        binding.edtSearchField.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                validateSearchField()
            }
            false
        }
        binding.btnSearch.setOnClickListener {
            validateSearchField()
        }
    }

    private fun validateSearchField() {
        if (!binding.edtSearchField.text?.trim().isNullOrEmpty()) {
            gotoListItemsView(R.id.action_searchFragment_to_listItemsFragment)
        } else {
            binding.edtSearchField.error = getString(R.string.search_fragment_search_field_empty)
        }
    }

    private fun gotoListItemsView(navigationAction: Int) {
        view?.findNavController()?.navigate(navigationAction)
    }
}
