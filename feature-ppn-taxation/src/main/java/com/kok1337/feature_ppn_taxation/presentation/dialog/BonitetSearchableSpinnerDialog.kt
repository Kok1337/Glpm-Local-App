package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.Bonitet
import com.kok1337.taxation.domain.model.Land

class BonitetSearchableSpinnerDialog(
    selectedBonitet: Bonitet?,
    searchableSpinnerRepository: SearchableSpinnerRepository<Bonitet>,
    onItemSelected: OnItemSelected<Bonitet>,
) : SimpleSearchableSpinnerDialog<Bonitet>(
    title = "Выберите Бонитет",
    selectedItem = selectedBonitet,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: Bonitet -> item.name },
    onItemSelected = onItemSelected,
)