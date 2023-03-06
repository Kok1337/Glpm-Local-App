package com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.kok1337.common_diff_callback.CommonCallbackImpl
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.delegate.AddressUserCoordinatesDelegate
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.item.AddressUserCoordinatesItem
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.listener.AdapterListener

internal class DescriptionItemAdapter(
    adapterListener: AdapterListener,
) : ListDelegationAdapter<List<DescriptionItem>>() {
    init {
        delegatesManager.addDelegate(AddressUserCoordinatesDelegate(adapterListener))
    }

    override fun setItems(items: List<DescriptionItem>?) {
        val oldItems = this.items ?: emptyList()
        val newItems = items ?: emptyList()
        val diffResult: DiffUtil.DiffResult = calculateDiff(oldItems, newItems)
        diffResult.dispatchUpdatesTo(this)
        super.setItems(items)
    }

    private fun calculateDiff(
        oldItems: List<DescriptionItem>,
        newItems: List<DescriptionItem>
    ): DiffUtil.DiffResult {
        val commonCallbackImpl = CommonCallbackImpl(
            oldItems,
            newItems,
            ::areItemsTheSameImpl,
            ::areContentsTheSame
        )
        return DiffUtil.calculateDiff(commonCallbackImpl)
    }

    private fun areItemsTheSameImpl(oldItem: DescriptionItem, newItem: DescriptionItem): Boolean {
        if (oldItem is AddressUserCoordinatesItem && newItem is AddressUserCoordinatesItem) {
            return true
        }
        return false
    }

    private fun areContentsTheSame(oldItem: DescriptionItem, newItem: DescriptionItem): Boolean {
        if (oldItem is AddressUserCoordinatesItem && newItem is AddressUserCoordinatesItem) {
            return oldItem == newItem
        }
        return false
    }
}