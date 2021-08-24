package com.example.myitemssearchk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myitemssearchk.R
import com.example.myitemssearchk.databinding.FragmentListItemsBinding
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.presentation.adapter.ListItemsAdapter
import com.example.myitemssearchk.presentation.extension.gone
import com.example.myitemssearchk.presentation.extension.visible
import com.example.myitemssearchk.presentation.states.ItemSearchState
import com.example.myitemssearchk.presentation.viewModels.ItemSearchDataViewModel
import com.example.myitemssearchk.presentation.viewModels.ItemSearchViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListItemsFragment : Fragment(R.layout.fragment_list_items) {

    private val itemSearchDataViewModel: ItemSearchDataViewModel by sharedViewModel()
    private val itemSearchViewModel: ItemSearchViewModel by viewModel()

    private val adapter = ListItemsAdapter(listOf()) { itemSearch ->
        itemSearchDataViewModel.itemData = itemSearch
        gotoItemDetailFragment(R.id.action_listItemsFragment_to_itemDetailFragment)
    }

    private lateinit var binding: FragmentListItemsBinding

    private var isNetworkError = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListItemsBinding.bind(view)
        initView()
        initListeners()
        initObservers()
    }

    private fun initView() {
        binding.apply {
            rvItemSearchList.layoutManager = LinearLayoutManager(context)
            rvItemSearchList.adapter = adapter
            txvItemSearched.text = itemSearchDataViewModel.textSearched
        }
        initSearch()
    }

    private fun initListeners() {
        binding.apply {
            tbItemSearchList.setNavigationOnClickListener {
                backPressed()
            }
            btnRetry.setOnClickListener {
                if (isNetworkError) {
                    initSearch()
                } else {
                    backPressed()
                }
            }
        }
    }

    private fun initObservers() {
        itemSearchViewModel.getItemSearchStateLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ItemSearchState.Loading -> {
                    showProgress()
                }
                is ItemSearchState.Success -> {
                    hideProgress()
                    binding.txvItemSearched.visible()
                    validateSearch(state.item)
                }
                is ItemSearchState.Error -> {
                    showNetworkError()
                }
                else -> {
                    showSearchError()
                }
            }
        })
    }

    private fun showProgress() {
        binding.apply {
            pbListItems.visible()
            txvNoDataFound.gone()
            ivIconSearchFailed.gone()
            rvItemSearchList.gone()
            btnRetry.gone()
            txvItemSearched.gone()
        }
    }

    private fun hideProgress() {
        binding.apply {
            pbListItems.gone()
            rvItemSearchList.visible()
        }
    }

    private fun showErrorFields() {
        binding.apply {
            txvNoDataFound.visible()
            ivIconSearchFailed.visible()
            rvItemSearchList.visible()
            txvItemSearched.gone()
        }
    }

    private fun showNetworkError() {
        isNetworkError = true
        hideProgress()
        showErrorFields()
        showNetworkErrorFiled()
    }

    private fun showSearchError() {
        hideProgress()
        showErrorFields()
        showNoFoundItem()
    }

    private fun showNoFoundItem(){
        binding.apply {
            ivIconSearchFailed.setBackgroundResource(R.drawable.ic_search_failed_100)
            txvNoDataFound.text = getString(R.string.list_items_fragment_no_data_found)
            btnRetry.text = getString(R.string.list_items_fragment_btn_return_to_search)
            btnRetry.visible()
        }
    }

    private fun showNetworkErrorFiled() {
        binding.apply {
            ivIconSearchFailed.setBackgroundResource(R.drawable.ic_wifi_off_120)
            txvNoDataFound.text = getString(R.string.list_items_fragment_network_error)
            btnRetry.text = getString(R.string.list_items_fragment_btn_retry)
            btnRetry.visible()
        }
    }

    private fun showItems(items: List<ItemSearch>) {
        adapter.data = items
    }

    private fun validateSearch(items: List<ItemSearch>) {
        if (!items.isNullOrEmpty()) {
            showItems(items)
        } else {
            showSearchError()
        }
    }

    private fun initSearch() {
        itemSearchViewModel.getItemSearch(itemSearchDataViewModel.textSearched)
    }

    private fun backPressed() {
        activity?.onBackPressed()
    }

    private fun gotoItemDetailFragment(navigationAction: Int) {
        view?.findNavController()?.navigate(navigationAction)
    }
}
