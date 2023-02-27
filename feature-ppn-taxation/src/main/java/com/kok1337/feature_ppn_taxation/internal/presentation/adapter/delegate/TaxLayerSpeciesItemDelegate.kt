package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxLayerSpeciesBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.TaxLayerSpeciesListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.TaxLayerSpeciesItem

internal class TaxLayerSpeciesItemDelegate(
    private val taxLayerSpeciesListener: TaxLayerSpeciesListener,
) :
    AbsListItemAdapterDelegate<TaxLayerSpeciesItem, ListItem, TaxLayerSpeciesItemDelegate.TaxLayerSpeciesItemViewHolder>() {
    inner class TaxLayerSpeciesItemViewHolder(val binding: ItemTaxLayerSpeciesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean = item is TaxLayerSpeciesItem

    override fun onCreateViewHolder(parent: ViewGroup): TaxLayerSpeciesItemViewHolder {
        val binding = ItemTaxLayerSpeciesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TaxLayerSpeciesItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: TaxLayerSpeciesItem,
        holder: TaxLayerSpeciesItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding
        val taxLayerSpecies = item.taxLayerSpecies
        binding.taxLayerSpeciesDeleteSpeciesButton.setOnClickListener {
            taxLayerSpeciesListener.onDeleteTaxLayerSpeciesClick(taxLayerSpecies)
        }
    }
}