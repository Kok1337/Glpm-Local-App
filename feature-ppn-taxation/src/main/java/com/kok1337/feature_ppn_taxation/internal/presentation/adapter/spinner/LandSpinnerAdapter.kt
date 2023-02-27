package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.spinner

import com.kok1337.land.api.model.Land
import com.kok1337.searchable_spinner.databinding.ItemSimpleViewBinding
import com.kok1337.searchable_spinner.presentation.adapter.SearchableSpinnerBindingAdapter
import com.kok1337.unforested_land.api.model.UnforestedLand

class LandSpinnerAdapter :
    SearchableSpinnerBindingAdapter<Land, ItemSimpleViewBinding>(com.kok1337.searchable_spinner.R.layout.item_simple_view) {
    override fun setupView(binding: ItemSimpleViewBinding, item: Land, position: Int) {
        binding.mainTextView.text = item.name
    }
}