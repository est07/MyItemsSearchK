package com.example.myitemssearchk.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.R
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.presentation.adapter.ViewHolder.ListItemsViewHolder
import com.example.myitemssearchk.presentation.extension.inflate
import com.example.myitemssearchk.presentation.listener.ListItemSearchListener
import kotlin.properties.Delegates

class ListItemsAdapter(
    data: List<ItemSearch> = emptyList(),
    private val listener: ListItemSearchListener
) : RecyclerView.Adapter<ListItemsViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemsViewHolder =
        ListItemsViewHolder(parent.inflate(R.layout.search_list_item),
            listener
        )

    override fun onBindViewHolder(holder: ListItemsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
