package com.kok1337.searchable_spinner.presentation.adapter

import com.kok1337.searchable_spinner.R
import com.kok1337.searchable_spinner.databinding.ItemSimpleViewBinding

internal class SimpleSearchableSpinnerAdapter<T>(
    private val selectedItem: T?,
    private val itemToTextTransformation: (T) -> String,
) : SearchableSpinnerBindingAdapter<T, ItemSimpleViewBinding>(
    R.layout.item_simple_view
) {
    override fun setupView(binding: ItemSimpleViewBinding, item: T, position: Int) {
        val textView = binding.mainTextView
        val drawableBackground = if (item == selectedItem)
            com.kok1337.iu.R.drawable.vbg_selected_textview
        else com.kok1337.iu.R.drawable.vbg_textview
        textView.setBackgroundResource(drawableBackground)
        textView.text = itemToTextTransformation(item)
    }
}