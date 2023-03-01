package com.kok1337.feature_ppn_taxation_sample.di.module.selector

import android.content.Context
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_taxation.api.dependencies.LandSelector
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.LandUseCaseModule
import com.kok1337.land.api.model.Land
import com.kok1337.land.api.use_case.GetAllLandUseCase
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LandUseCaseModule::class,
    ]
)
internal interface LandSelectorModule {
    companion object {
        @Provides
        fun landSelector(
            context: Context,
            getAllLandUseCase: GetAllLandUseCase,
        ): LandSelector = object : LandSelector {
            override suspend fun selectLand(currentLand: Land?, onLandSelected: (Land?) -> Unit) {
                val repository = SearchableSpinnerRepository { _, _ ->
                    getAllLandUseCase()
                }
                val itemToText = { item: Land -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = "Выберите земли",
                    selectedItem = currentLand,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onLandSelected
                )
                showDialog(dialog, context)
            }
        }
    }
}