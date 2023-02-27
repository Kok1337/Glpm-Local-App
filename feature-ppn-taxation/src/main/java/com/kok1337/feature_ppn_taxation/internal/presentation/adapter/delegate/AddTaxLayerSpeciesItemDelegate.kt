package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemAddTaxLayerBinding
import com.kok1337.feature_ppn_taxation.databinding.ItemAddTaxLayerSpeciesBinding
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.AddTaxLayerSpeciesListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.AddTaxLayerItem
import com.kok1337.feature_ppn_taxation.internal.presentation.item.AddTaxLayerSpeciesItem
import com.kok1337.feature_ppn_taxation.internal.presentation.item.TaxItem

internal class AddTaxLayerSpeciesItemDelegate(
    private val addTaxLayerSpeciesListener: AddTaxLayerSpeciesListener,
) :
    AbsListItemAdapterDelegate<AddTaxLayerSpeciesItem, ListItem, AddTaxLayerSpeciesItemDelegate.AddTaxLayerSpeciesItemViewHolder>() {
    inner class AddTaxLayerSpeciesItemViewHolder(val binding: ItemAddTaxLayerSpeciesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean = item is AddTaxLayerSpeciesItem

    override fun onCreateViewHolder(parent: ViewGroup): AddTaxLayerSpeciesItemViewHolder {
        val binding = ItemAddTaxLayerSpeciesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddTaxLayerSpeciesItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: AddTaxLayerSpeciesItem,
        holder: AddTaxLayerSpeciesItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding
        val taxLayerId = item.taxLayerId
        binding.addTaxLayerSpeciesButton.setOnClickListener {
            addTaxLayerSpeciesListener.onAddTaxLayerSpeciesClick(taxLayerId)
        }
    }
}