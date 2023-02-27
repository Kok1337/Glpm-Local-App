package com.kok1337.searchable_spinner.domain.usecase

import com.kok1337.searchable_spinner.domain.model.SortType
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository

internal class GetDataForSearchableSpinnerUseCase<T> constructor(
    private val searchableSpinnerRepository: SearchableSpinnerRepository<T>,
) {
    suspend fun invoke(search: String = "", sortType: SortType? = null): List<T> {
        return searchableSpinnerRepository.getAll(search, sortType)
    }
}