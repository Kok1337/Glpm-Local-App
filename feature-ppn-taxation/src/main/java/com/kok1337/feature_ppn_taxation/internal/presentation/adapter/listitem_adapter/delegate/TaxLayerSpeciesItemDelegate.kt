package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxLayerSpeciesBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.listener.TaxLayerSpeciesListener
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
        val taxLayerSpeciesItem = item.taxLayerSpeciesId
        val binding = holder.binding

        binding.taxLayerSpeciesDeleteSpeciesButton.setOnClickListener {
            taxLayerSpeciesListener.onDeleteTaxLayerSpeciesClick(item.taxLayerSpeciesId)
        }

        binding.taxLayerSpeciesCoeffTextView.text = item.coeff?.toString() ?: ""
        binding.taxLayerSpeciesCoeffTextView.setOnClickListener {
            taxLayerSpeciesListener.onCoeffClick(taxLayerSpeciesItem, item.coeff)
        }

        binding.taxLayerSpeciesShortNameTextView.text = item.species?.shortName ?: ""
        binding.taxLayerSpeciesShortNameTextView.setOnClickListener {
            taxLayerSpeciesListener.onSpeciesClick(taxLayerSpeciesItem, item.species)
        }

        binding.taxLayerSpeciesAgeTextView.text = item.age?.toString() ?: ""
        binding.taxLayerSpeciesAgeTextView.setOnClickListener {
            taxLayerSpeciesListener.onAgeClick(taxLayerSpeciesItem, item.age)
        }

        binding.taxLayerSpeciesHeightTextView.text = item.height?.toString() ?: ""
        binding.taxLayerSpeciesHeightTextView.setOnClickListener {
            taxLayerSpeciesListener.onTaxLayerSpeciesHeightClick(taxLayerSpeciesItem, item.height)
        }

        binding.taxLayerSpeciesDiameterTextView.text = item.diameter?.toString() ?: ""
        binding.taxLayerSpeciesDiameterTextView.setOnClickListener {
            taxLayerSpeciesListener.onDiameterClick(taxLayerSpeciesItem, item.diameter)
        }

        binding.taxLayerSpeciesStockTextView.text = item.stock?.toString() ?: ""
    }
}