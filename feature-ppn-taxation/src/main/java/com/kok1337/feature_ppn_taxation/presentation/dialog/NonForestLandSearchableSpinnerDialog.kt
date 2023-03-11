package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.NonForestLand

class NonForestLandSearchableSpinnerDialog(
    selectedNonForestLand: NonForestLand?,
    searchableSpinnerRepository: SearchableSpinnerRepository<NonForestLand>,
    onItemSelected: OnItemSelected<NonForestLand>,
) : SimpleSearchableSpinnerDialog<NonForestLand>(
    title = "Выберите Не лесные земли",
    selectedItem = selectedNonForestLand,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: NonForestLand -> item.name },
    onItemSelected = onItemSelected,
)