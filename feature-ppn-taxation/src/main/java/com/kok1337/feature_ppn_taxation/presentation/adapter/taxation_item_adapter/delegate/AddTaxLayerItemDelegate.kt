package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemAddTaxLayerBinding
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener.AddTaxLayerListener
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.AddTaxLayerItem

internal class AddTaxLayerItemDelegate(
    private val addTaxLayerListener: AddTaxLayerListener,
) :
    AbsListItemAdapterDelegate<AddTaxLayerItem, TaxationItem, AddTaxLayerItemDelegate.AddTaxLayerItemViewHolder>() {
    inner class AddTaxLayerItemViewHolder(val binding: ItemAddTaxLayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: TaxationItem,
        items: MutableList<TaxationItem>,
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