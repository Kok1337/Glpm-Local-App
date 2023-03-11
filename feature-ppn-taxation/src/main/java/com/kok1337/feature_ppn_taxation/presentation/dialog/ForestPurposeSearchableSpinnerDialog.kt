package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.ForestPurpose

class ForestPurposeSearchableSpinnerDialog(
    selectedForestPurpose: ForestPurpose?,
    searchableSpinnerRepository: SearchableSpinnerRepository<ForestPurpose>,
    onItemSelected: OnItemSelected<ForestPurpose>,
) : SimpleSearchableSpinnerDialog<ForestPurpose>(
    title = "Выберите Целевое назначение",
    selectedItem = selectedForestPurpose,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: ForestPurpose -> item.name },
    onItemSelected = onItemSelected,
)