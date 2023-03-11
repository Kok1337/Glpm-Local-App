package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.Ozu

class OzuSearchableSpinnerDialog(
    selectedOzu: Ozu?,
    searchableSpinnerRepository: SearchableSpinnerRepository<Ozu>,
    onItemSelected: OnItemSelected<Ozu>,
) : SimpleSearchableSpinnerDialog<Ozu>(
    title = "Выберите ОЗУ",
    selectedItem = selectedOzu,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: Ozu -> item.name },
    onItemSelected = onItemSelected,
)