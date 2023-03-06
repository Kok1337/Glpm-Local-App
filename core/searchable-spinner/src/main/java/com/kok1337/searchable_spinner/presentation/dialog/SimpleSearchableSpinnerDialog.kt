package com.kok1337.searchable_spinner.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.adapter.SimpleSearchableSpinnerAdapter

open class SimpleSearchableSpinnerDialog<T>(
    title: String,
    selectedItem: T?,
    searchableSpinnerRepository: SearchableSpinnerRepository<T>,
    itemToTextTransformation: (T) -> String,
    onItemSelected: OnItemSelected<T>
) : SearchableSpinnerDialog<T>(
    title = title,
    searchableSpinnerAdapter = SimpleSearchableSpinnerAdapter(
        selectedItem,
        itemToTextTransformation
    ),
    searchableSpinnerRepository = searchableSpinnerRepository,
    onItemSelected = onItemSelected
)