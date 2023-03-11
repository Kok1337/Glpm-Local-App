package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.UnforestedLand

class UnforestedLandSearchableSpinnerDialog(
    selectedUnforestedLand: UnforestedLand?,
    searchableSpinnerRepository: SearchableSpinnerRepository<UnforestedLand>,
    onItemSelected: OnItemSelected<UnforestedLand>,
) : SimpleSearchableSpinnerDialog<UnforestedLand>(
    title = "Выберите Лесные земли",
    selectedItem = selectedUnforestedLand,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: UnforestedLand -> item.name },
    onItemSelected = onItemSelected,
)