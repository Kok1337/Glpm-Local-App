package com.kok1337.feature_ppn_description.presentation.dialog

import com.kok1337.address.domain.model.Region
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.OnItemSelected
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog

class RegionSearchableSpinnerDialog(
    selectedRegion: Region?,
    searchableSpinnerRepository: SearchableSpinnerRepository<Region>,
    onItemSelected: OnItemSelected<Region>,
) : SimpleSearchableSpinnerDialog<Region>(
    title = "Выберите Субъект РФ",
    selectedItem = selectedRegion,
    searchableSpinnerRepository = searchableSpinnerRepository,
    itemToTextTransformation = { item: Region -> item.name },
    onItemSelected = onItemSelected,
)