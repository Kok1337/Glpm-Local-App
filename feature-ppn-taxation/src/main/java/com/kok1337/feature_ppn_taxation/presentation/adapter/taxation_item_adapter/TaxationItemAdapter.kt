package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.kok1337.common_diff_callback.CommonCallbackImpl
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate.AddTaxLayerItemDelegate
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate.AddTaxSpeciesItemDelegate
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate.TaxItemDelegate
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate.TaxLayerItemDelegate
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.delegate.TaxSpeciesItemDelegate
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener.AdapterListener
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.AddTaxLayerItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.AddTaxSpeciesItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.TaxItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.TaxLayerItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.TaxSpeciesItem

internal class TaxationItemAdapter(
    adapterListener: AdapterListener,
) : ListDelegationAdapter<List<TaxationItem>>() {
    init {
        delegatesManager.addDelegate(TaxItemDelegate(adapterListener))
        delegatesManager.addDelegate(TaxLayerItemDelegate(adapterListener))
        delegatesManager.addDelegate(TaxSpeciesItemDelegate(adapterListener))
        delegatesManager.addDelegate(AddTaxLayerItemDelegate(adapterListener))
        delegatesManager.addDelegate(AddTaxSpeciesItemDelegate(adapterListener))
    }

    override fun setItems(items: List<TaxationItem>?) {
        val oldItems = this.items ?: emptyList()
        val newItems = items ?: emptyList()
        val diffResult: DiffUtil.DiffResult = calculateDiff(oldItems, newItems)
        diffResult.dispatchUpdatesTo(this)
        super.setItems(items)
    }

    private fun calculateDiff(
        oldItems: List<TaxationItem>,
        newItems: List<TaxationItem>
    ): DiffUtil.DiffResult {
        val commonCallbackImpl = CommonCallbackImpl(
            oldItems,
            newItems,
            ::areItemsTheSameImpl,
            ::areContentsTheSame
        )
        return DiffUtil.calculateDiff(commonCallbackImpl)
    }

    private fun areItemsTheSameImpl(oldItem: TaxationItem, newItem: TaxationItem): Boolean {
        if (oldItem is TaxItem && newItem is TaxItem) {
            return oldItem.taxId == newItem.taxId
        }
        if (oldItem is TaxLayerItem && newItem is TaxLayerItem) {
            return oldItem.taxLayerId == newItem.taxLayerId
        }
        if (oldItem is TaxSpeciesItem && newItem is TaxSpeciesItem) {
            return oldItem.taxLayerSpeciesId == newItem.taxLayerSpeciesId
        }
        if (oldItem is AddTaxLayerItem && newItem is AddTaxLayerItem) {
            return oldItem.taxId == newItem.taxId
        }
        if (oldItem is AddTaxSpeciesItem && newItem is AddTaxSpeciesItem) {
            return oldItem.taxLayerId == newItem.taxLayerId
        }
        return false
    }

    private fun areContentsTheSame(oldItem: TaxationItem, newItem: TaxationItem): Boolean {
        if (oldItem is TaxItem && newItem is TaxItem) {
            return oldItem == newItem
        }
        if (oldItem is TaxLayerItem && newItem is TaxLayerItem) {
            return oldItem == newItem
        }
        if (oldItem is TaxSpeciesItem && newItem is TaxSpeciesItem) {
            return oldItem == newItem
        }
        if (oldItem is AddTaxLayerItem && newItem is AddTaxLayerItem) {
            return oldItem == newItem
        }
        if (oldItem is AddTaxSpeciesItem && newItem is AddTaxSpeciesItem) {
            return oldItem == newItem
        }
        return false
    }
}