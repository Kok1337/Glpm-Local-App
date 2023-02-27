package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemAddTaxLayerBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.AddTaxLayerListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.AddTaxLayerItem

internal class AddTaxLayerItemDelegate(
    private val addTaxLayerListener: AddTaxLayerListener,
) :
    AbsListItemAdapterDelegate<AddTaxLayerItem, ListItem, AddTaxLayerItemDelegate.AddTaxLayerItemViewHolder>() {
    inner class AddTaxLayerItemViewHolder(val binding: ItemAddTaxLayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean = item is AddTaxLayerItem

    override fun onCreateViewHolder(parent: ViewGroup): AddTaxLayerItemViewHolder {
        val binding = ItemAddTaxLayerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddTaxLayerItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: AddTaxLayerItem,
        holder: AddTaxLayerItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding
        val taxId = item.taxId
        binding.addTaxLayerButton.setOnClickListener {
            addTaxLayerListener.onAddTaxLayerClick(taxId)
        }
    }
}