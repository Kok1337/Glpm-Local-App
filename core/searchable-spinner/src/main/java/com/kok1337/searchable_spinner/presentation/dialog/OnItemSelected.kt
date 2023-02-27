package com.kok1337.searchable_spinner.presentation.dialog

fun interface OnItemSelected<T> {
    fun invoke(item: T?)
}