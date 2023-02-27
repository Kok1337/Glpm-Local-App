package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.spinner

import com.kok1337.searchable_spinner.databinding.ItemSimpleViewBinding
import com.kok1337.searchable_spinner.presentation.adapter.SearchableSpinnerBindingAdapter
import com.kok1337.unforested_land.api.model.UnforestedLand

class UnforestedLandSpinnerAdapter :
    SearchableSpinnerBindingAdapter<UnforestedLand, ItemSimpleViewBinding>(com.kok1337.searchable_spinner.R.layout.item_simple_view) {
    override fun setupView(binding: ItemSimpleViewBinding, item: UnforestedLand, position: Int) {
        binding.mainTextView.text = item.name
    }
}