package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.Land

class LandSearchableSpinnerDialog(
    selectedLand: Land?,
    searchableSpinnerRepository: SearchableSpinnerRepository<Land>,
    onItemSelected: OnItemSelected<Land>,
) : SimpleSearchableSpinnerDialog<Land>(
    title = "Выберите Земли",
    selectedItem = selectedLand,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: Land -> item.name },
    onItemSelected = onItemSelected,
)