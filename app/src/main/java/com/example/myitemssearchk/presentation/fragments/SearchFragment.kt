package com.example.myitemssearchk.presentation.fragments

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myitemssearchk.R
import com.example.myitemssearchk.databinding.FragmentSearchBinding
import com.example.myitemssearchk.presentation.viewModels.ItemSearchDataViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val itemSearchDataViewModel: ItemSearchDataViewModel by sharedViewModel()

    private var binding: FragmentSearchBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        initListener()
    }

    private fun initListener() {
        binding?.apply {
            edtSearchField.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    validateSearchField()
                }
                false
            }
            btnSearch.setOnClickListener {
                validateSearchField()
            }
        }
    }

    private fun validateSearchField() {
        binding?.apply {
            if (!edtSearchField.text?.trim().isNullOrEmpty()) {
                itemSearchDataViewModel.textSearched = edtSearchField.text.toString().trim()
                gotoListItemsView(R.id.action_searchFragment_to_listItemsFragment)
            } else {
                edtSearchField.error = getString(R.string.search_fragment_search_field_empty)
            }
        }
    }

    private fun gotoListItemsView(navigationAction: Int) {
        view?.findNavController()?.navigate(navigationAction)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
