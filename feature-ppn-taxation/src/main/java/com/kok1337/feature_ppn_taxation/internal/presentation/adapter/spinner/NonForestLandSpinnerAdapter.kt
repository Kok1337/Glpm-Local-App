package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.spinner

import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.searchable_spinner.databinding.ItemSimpleViewBinding
import com.kok1337.searchable_spinner.presentation.adapter.SearchableSpinnerBindingAdapter

class NonForestLandSpinnerAdapter :
    SearchableSpinnerBindingAdapter<NonForestLand, ItemSimpleViewBinding>(com.kok1337.searchable_spinner.R.layout.item_simple_view) {
    override fun setupView(binding: ItemSimpleViewBinding, item: NonForestLand, position: Int) {
        binding.mainTextView.text = item.name
    }
}