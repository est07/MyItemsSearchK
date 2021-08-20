package com.example.myitemssearchk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.myitemssearchk.R
import com.example.myitemssearchk.databinding.FragmentItemDetailBinding
import com.example.myitemssearchk.presentation.viewModels.ItemSearchDataViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ItemDetailFragment : Fragment(R.layout.fragment_item_detail) {

    private val itemSearchDataViewModel: ItemSearchDataViewModel by sharedViewModel()

    private lateinit var binding: FragmentItemDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemDetailBinding.bind(view)
    }

}
