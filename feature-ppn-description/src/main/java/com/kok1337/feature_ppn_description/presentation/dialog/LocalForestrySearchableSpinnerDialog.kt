package com.kok1337.feature_ppn_description.presentation.dialog

import com.kok1337.address.domain.model.LocalForestry
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog

class LocalForestrySearchableSpinnerDialog(
    selectedLocalForestry: LocalForestry?,
    searchableSpinnerRepository: SearchableSpinnerRepository<LocalForestry>,
    onItemSelected: OnItemSelected<LocalForestry>,
) : SimpleSearchableSpinnerDialog<LocalForestry>(
    title = "Выберите Участковое лесничество",
    selectedItem = selectedLocalForestry,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: LocalForestry -> item.name },
    onItemSelected = onItemSelected,
)