package com.kok1337.feature_ppn_description.presentation.dialog

import com.kok1337.address.domain.model.SubForestry
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog

class SubForestrySearchableSpinnerDialog(
    selectedSubForestry: SubForestry?,
    searchableSpinnerRepository: SearchableSpinnerRepository<SubForestry>,
    onItemSelected: OnItemSelected<SubForestry>,
) : SimpleSearchableSpinnerDialog<SubForestry>(
    title = "Выберите Подлесничество/Урочище",
    selectedItem = selectedSubForestry,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: SubForestry -> item.name },
    onItemSelected = onItemSelected,
)