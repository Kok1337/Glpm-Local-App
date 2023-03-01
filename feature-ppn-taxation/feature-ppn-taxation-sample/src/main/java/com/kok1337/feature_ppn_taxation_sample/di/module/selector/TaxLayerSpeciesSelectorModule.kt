package com.kok1337.feature_ppn_taxation_sample.di.module.selector

import android.content.Context
import com.kok1337.dialog.presentation.dialog.InputIntDialog
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxLayerSpeciesSelector
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.SpeciesUseCaseModule
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.species.api.model.Species
import com.kok1337.species.api.use_case.GetAllSpeciesUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        SpeciesUseCaseModule::class,
    ]
)
internal interface TaxLayerSpeciesSelectorModule {
    companion object {
        @Provides
        fun taxLayerSpeciesSelector(
            context: Context,
            getAllSpeciesUseCase: GetAllSpeciesUseCase,
        ): TaxLayerSpeciesSelector = object : TaxLayerSpeciesSelector {
            override suspend fun selectCoeff(currentCoeff: Int?, onCoeffSelected: (Int?) -> Unit) {
                val title = "Введите коэфф."
                val dialog = InputIntDialog(
                    title = title,
                    startValue = currentCoeff,
                    isNullable = true,
                    onValueIntroduced = onCoeffSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectSpecies(
                currentSpecies: Species?,
                onSpeciesSelected: (Species?) -> Unit
            ) {
                val title = "Выберите породу"
                val repository = SearchableSpinnerRepository { _, _ ->
                    getAllSpeciesUseCase()
                }
                val itemToText = { item: Species -> item.fullName }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentSpecies,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onSpeciesSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectAge(currentAge: Int?, onAgeSelected: (Int?) -> Unit) {
                val title = "Введите возраст породы"
                val dialog = InputIntDialog(
                    title = title,
                    startValue = currentAge,
                    isNullable = true,
                    onValueIntroduced = onAgeSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectHeight(
                currentHeight: Int?,
                onHeightSelected: (Int?) -> Unit
            ) {
                val title = "Введите высоту породы"
                val dialog = InputIntDialog(
                    title = title,
                    startValue = currentHeight,
                    isNullable = true,
                    onValueIntroduced = onHeightSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectDiameter(
                currentDiameter: Int?,
                onDiameterSelected: (Int?) -> Unit
            ) {
                val title = "Введите диаметр породы"
                val dialog = InputIntDialog(
                    title = title,
                    startValue = currentDiameter,
                    isNullable = true,
                    onValueIntroduced = onDiameterSelected
                )
                showDialog(dialog, context)
            }
        }
    }
}