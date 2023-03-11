package com.kok1337.feature_ppn_taxation.presentation.dialog

import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.taxation.domain.model.AgeGroup
import com.kok1337.taxation.domain.model.Bonitet
import com.kok1337.taxation.domain.model.Land

class AgeGroupSearchableSpinnerDialog(
    selectedAgeGroup: AgeGroup?,
    searchableSpinnerRepository: SearchableSpinnerRepository<AgeGroup>,
    onItemSelected: OnItemSelected<AgeGroup>,
) : SimpleSearchableSpinnerDialog<AgeGroup>(
    title = "Выберите Группу возраста",
    selectedItem = selectedAgeGroup,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: AgeGroup -> item.name },
    onItemSelected = onItemSelected,
)