package com.example.myitemssearchk.presentation.adapter.ViewHolder

import android.graphics.Color
import android.system.Os.bind
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.databinding.ActivityMainBinding.bind
import com.example.myitemssearchk.databinding.SearchListItemBinding
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.presentation.Constants.Companion.BASE_IMAGE_URL
import com.example.myitemssearchk.presentation.extension.getImageByUrl
import com.example.myitemssearchk.presentation.listener.ListItemSearchListener


class ListItemsViewHolder(
    view: View,
    val listener: ListItemSearchListener
) : RecyclerView.ViewHolder(view) {

    private val binding = SearchListItemBinding.bind(view)
    fun bind(item: ItemSearch) = with(binding) {
        txvItemSearchTitle.text = item.title
        txvItemPrice.text = item.price.toString()
        imvItemSearch.getImageByUrl("$BASE_IMAGE_URL${item.itemImage}")
        imvItemSearch.setBackgroundColor(Color.TRANSPARENT)
        root.setOnClickListener { listener(item) }
    }
}
