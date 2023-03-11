package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxLayerSpeciesBinding
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener.TaxSpeciesListener
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.TaxSpeciesItem

internal class TaxSpeciesItemDelegate(
    private val taxSpeciesListener: TaxSpeciesListener,
) :
    AbsListItemAdapterDelegate<TaxSpeciesItem, TaxationItem, TaxSpeciesItemDelegate.TaxLayerSpeciesItemViewHolder>() {
    inner class TaxLayerSpeciesItemViewHolder(val binding: ItemTaxLayerSpeciesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: TaxationItem,
        items: MutableList<TaxationItem>,
        position: Int
    ): Boolean = item is TaxSpeciesItem

    override fun onCreateViewHolder(parent: ViewGroup): TaxLayerSpeciesItemViewHolder {
        val binding = ItemTaxLayerSpeciesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TaxLayerSpeciesItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: TaxSpeciesItem,
        holder: TaxLayerSpeciesItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val taxSpeciesItem = item.taxLayerSpeciesId
        val binding = holder.binding

        binding.taxLayerSpeciesDeleteSpeciesButton.setOnClickListener {
            taxSpeciesListener.onDeleteTaxLayerSpeciesClick(item.taxLayerSpeciesId)
        }

        binding.taxLayerSpeciesCoeffTextView.text = item.coeff?.toString() ?: ""
        binding.taxLayerSpeciesCoeffTextView.setOnClickListener {
            taxSpeciesListener.onCoeffClick(taxSpeciesItem, item.coeff)
        }

        binding.taxLayerSpeciesShortNameTextView.text = item.species?.shortName ?: ""
        binding.taxLayerSpeciesShortNameTextView.setOnClickListener {
            taxSpeciesListener.onSpeciesClick(taxSpeciesItem, item.species)
        }

        binding.taxLayerSpeciesAgeTextView.text = item.age?.toString() ?: ""
        binding.taxLayerSpeciesAgeTextView.setOnClickListener {
            taxSpeciesListener.onAgeClick(taxSpeciesItem, item.age)
        }

        binding.taxLayerSpeciesHeightTextView.text = item.height?.toString() ?: ""
        binding.taxLayerSpeciesHeightTextView.setOnClickListener {
            taxSpeciesListener.onTaxLayerSpeciesHeightClick(taxSpeciesItem, item.height)
        }

        binding.taxLayerSpeciesDiameterTextView.text = item.diameter?.toString() ?: ""
        binding.taxLayerSpeciesDiameterTextView.setOnClickListener {
            taxSpeciesListener.onDiameterClick(taxSpeciesItem, item.diameter)
        }

        binding.taxLayerSpeciesStockTextView.text = item.stock?.toString() ?: ""
    }
}