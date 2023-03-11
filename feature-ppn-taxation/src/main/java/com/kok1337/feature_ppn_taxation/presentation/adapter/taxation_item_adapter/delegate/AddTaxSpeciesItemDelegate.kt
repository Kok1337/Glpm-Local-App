package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemAddTaxLayerSpeciesBinding
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener.AddTaxSpeciesListener
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.AddTaxSpeciesItem

internal class AddTaxSpeciesItemDelegate(
    private val addTaxSpeciesListener: AddTaxSpeciesListener,
) :
    AbsListItemAdapterDelegate<AddTaxSpeciesItem, TaxationItem, AddTaxSpeciesItemDelegate.AddTaxLayerSpeciesItemViewHolder>() {
    inner class AddTaxLayerSpeciesItemViewHolder(val binding: ItemAddTaxLayerSpeciesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: TaxationItem,
        items: MutableList<TaxationItem>,
        position: Int
    ): Boolean = item is AddTaxSpeciesItem

    override fun onCreateViewHolder(parent: ViewGroup): AddTaxLayerSpeciesItemViewHolder {
        val binding = ItemAddTaxLayerSpeciesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddTaxLayerSpeciesItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: AddTaxSpeciesItem,
        holder: AddTaxLayerSpeciesItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding
        val taxLayerId = item.taxLayerId
        binding.addTaxLayerSpeciesButton.setOnClickListener {
            addTaxSpeciesListener.onAddTaxLayerSpeciesClick(taxLayerId)
        }
    }
}