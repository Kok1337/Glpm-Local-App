package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.species.domain.model.Species

class SpeciesSearchableSpinnerDialog(
    selectedSpecies: Species?,
    searchableSpinnerRepository: SearchableSpinnerRepository<Species>,
    onItemSelected: OnItemSelected<Species>,
) : SimpleSearchableSpinnerDialog<Species>(
    title = "Выберите Породу",
    selectedItem = selectedSpecies,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: Species -> "${item.shortName} - ${item.fullName}" },
    onItemSelected = onItemSelected,
)