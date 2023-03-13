package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxLayerBinding
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.TaxLayerItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener.TaxLayerListener

internal class TaxLayerItemDelegate(
    private val taxLayerListener: TaxLayerListener,
) :
    AbsListItemAdapterDelegate<TaxLayerItem, TaxationItem, TaxLayerItemDelegate.TaxLayerItemViewHolder>() {
    inner class TaxLayerItemViewHolder(val binding: ItemTaxLayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: TaxationItem,
        items: MutableList<TaxationItem>,
        position: Int
    ): Boolean = item is TaxLayerItem

    override fun onCreateViewHolder(parent: ViewGroup): TaxLayerItemViewHolder {
        val binding =
            ItemTaxLayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaxLayerItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: TaxLayerItem,
        holder: TaxLayerItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val taxLayerId = item.taxLayerId
        val binding = holder.binding

        binding.taxLayerCompositionTextView.text = item.composition
        binding.taxLayerCompositionTextView.setOnLongClickListener {
            taxLayerListener.onCompositionLongClick(item.composition)
            true
        }

        binding.taxLayerNumberTextView.text = "Ярус ${item.taxLayerNum}"
        binding.taxLayerDeleteButton.setOnClickListener {
            taxLayerListener.onDeleteTaxLayerClick(taxLayerId)
        }

        binding.taxLayerHeightTextView.text = item.height?.toString() ?: ""
        binding.taxLayerHeightTextView.setOnClickListener {
            taxLayerListener.onTaxLayerHeightClick(taxLayerId, item.height)
        }

        binding.taxLayerAgeClassTextView.text = item.ageClass?.toString() ?: ""
        binding.taxLayerAgeClassTextView.setOnClickListener {
            taxLayerListener.onAgeClassClick(taxLayerId, item.ageClass)
        }

        binding.taxLayerAgeGroupTextView.text = item.ageGroup?.id?.toString() ?: ""
        binding.taxLayerAgeGroupTextView.setOnClickListener {
            taxLayerListener.onAgeGroupClick(taxLayerId, item.ageGroup)
        }
        binding.taxLayerAgeGroupTextView.setOnLongClickListener {
            taxLayerListener.onAgeGroupLongClick(item.ageGroup)
            true
        }

        binding.taxLayerFullnessTextView.text = item.fullness?.toString() ?: ""
        binding.taxLayerFullnessTextView.setOnClickListener {
            taxLayerListener.onFullnessClick(taxLayerId, item.fullness)
        }

        binding.taxLayerStockTextView.text = item.stock?.toString() ?: ""
        binding.taxLayerStockTextView.setOnClickListener {
            taxLayerListener.onStockClick(taxLayerId, item.stock)
        }
    }
}