package com.kok1337.feature_ppn_description.internal.presentation.dialog

import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog

class ForestrySearchableSpinnerDialog(
    selectedForestry: Forestry?,
    searchableSpinnerRepository: SearchableSpinnerRepository<Forestry>,
    onItemSelected: OnItemSelected<Forestry>,
) : SimpleSearchableSpinnerDialog<Forestry>(
    title = "Выберите Лесничество",
    selectedItem = selectedForestry,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: Forestry -> item.name },
    onItemSelected = onItemSelected,
)