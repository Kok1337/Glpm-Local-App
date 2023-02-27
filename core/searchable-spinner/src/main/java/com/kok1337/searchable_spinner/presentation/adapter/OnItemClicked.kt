package com.kok1337.searchable_spinner.presentation.adapter

fun interface OnItemClicked<T> {
    fun invoke(item: T)
}