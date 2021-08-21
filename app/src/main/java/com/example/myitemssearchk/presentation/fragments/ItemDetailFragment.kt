package com.example.myitemssearchk.presentation.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.text.HtmlCompat
import com.example.myitemssearchk.R
import com.example.myitemssearchk.databinding.FragmentItemDetailBinding
import com.example.myitemssearchk.presentation.Constants
import com.example.myitemssearchk.presentation.extension.getImageByUrl
import com.example.myitemssearchk.presentation.viewModels.ItemSearchDataViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ItemDetailFragment : Fragment(R.layout.fragment_item_detail) {

    private val itemSearchDataViewModel: ItemSearchDataViewModel by sharedViewModel()

    private lateinit var binding: FragmentItemDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemDetailBinding.bind(view)

        initView()
        initListeners()
    }

    private fun initView() {
        binding.apply {
            itemSearchDataViewModel.itemData?.run {
                imvItemImage.getImageByUrl(
                    itemImage
                        .replace(
                            Constants.BASE_HTTP_URL,
                            Constants.BASE_HTTPS_URL
                        )
                )
                txvItemTitle.text = title
                txvItemPrize.text = getString(R.string.price_format, price.toDouble().toString())

                txvItemLocation.text = getString(
                    R.string.item_detail_fragment_detail_address_information,
                    neighborhoodName,
                    cityName,
                    countryName
                )
                txvItemMoreInformationLink.text = HtmlCompat.fromHtml(
                    getString(
                        R.string.item_detail_fragment_detail_item_link,
                        descriptionLink
                    ),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
        }
    }

    private fun initListeners(){
        binding.apply {
            tbItemDetail.setNavigationOnClickListener {
                backPressed()
            }
            txvItemMoreInformationLink.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(itemSearchDataViewModel.itemData?.descriptionLink)
                    )
                )
            }
        }
    }

    private fun backPressed() {
        itemSearchDataViewModel.itemData = null
        activity?.onBackPressed()
    }
}
