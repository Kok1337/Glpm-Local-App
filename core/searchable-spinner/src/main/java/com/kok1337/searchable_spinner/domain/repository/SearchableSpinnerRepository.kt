package com.kok1337.searchable_spinner.domain.repository

import com.kok1337.searchable_spinner.domain.model.SortType

fun interface SearchableSpinnerRepository<T> {
    suspend fun getAll(search: String, sortType: SortType?): List<T>
}