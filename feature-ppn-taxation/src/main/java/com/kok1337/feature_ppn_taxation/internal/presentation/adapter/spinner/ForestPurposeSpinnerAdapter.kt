package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.spinner

import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.searchable_spinner.databinding.ItemSimpleViewBinding
import com.kok1337.searchable_spinner.presentation.adapter.SearchableSpinnerBindingAdapter

class ForestPurposeSpinnerAdapter :
    SearchableSpinnerBindingAdapter<ForestPurpose, ItemSimpleViewBinding>(com.kok1337.searchable_spinner.R.layout.item_simple_view) {
    override fun setupView(binding: ItemSimpleViewBinding, item: ForestPurpose, position: Int) {
        binding.mainTextView.text = item.name
    }
}