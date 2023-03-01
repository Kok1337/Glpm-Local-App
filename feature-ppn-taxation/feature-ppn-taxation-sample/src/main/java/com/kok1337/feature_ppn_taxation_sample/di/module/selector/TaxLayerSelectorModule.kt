package com.kok1337.feature_ppn_taxation_sample.di.module.selector

import android.content.Context
import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.age_group.api.use_case.GetAllAgeGroupBySearchUseCase
import com.kok1337.dialog.presentation.dialog.InputDoubleDialog
import com.kok1337.dialog.presentation.dialog.InputIntDialog
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxLayerSelector
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.AgeGroupUseCaseModule
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AgeGroupUseCaseModule::class,
    ]
)
internal interface TaxLayerSelectorModule {
    companion object {
        @Provides
        fun taxLayerSelector(
            context: Context,
            getAllAgeGroupBySearchUseCase: GetAllAgeGroupBySearchUseCase,
        ): TaxLayerSelector = object : TaxLayerSelector {
            override suspend fun selectHeight(
                currentHeight: Int?,
                onHeightSelected: (Int?) -> Unit
            ) {
                val title = "Введите высоту яруса"
                val dialog = InputIntDialog(
                    title = title,
                    startValue = currentHeight,
                    isNullable = true,
                    onValueIntroduced = onHeightSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectAgeClass(
                currentAgeClass: Int?,
                onAgeClassSelected: (Int?) -> Unit
            ) {
                val title = "Введите класс возраста"
                val dialog = InputIntDialog(
                    title = title,
                    startValue = currentAgeClass,
                    isNullable = true,
                    onValueIntroduced = onAgeClassSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectAgeGroup(
                currentAgeGroup: AgeGroup?,
                onAgeGroupSelected: (AgeGroup?) -> Unit
            ) {
                val title = "Выберите группу возраста"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllAgeGroupBySearchUseCase(search)
                }
                val itemToText = { item: AgeGroup -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentAgeGroup,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onAgeGroupSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectFullness(
                currentFullness: Double?,
                onFullnessSelected: (Double?) -> Unit
            ) {
                val title = "Введите полноту"
                val dialog = InputDoubleDialog(
                    title = title,
                    startValue = currentFullness,
                    isNullable = true,
                    onValueIntroduced = onFullnessSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectStock(
                currentStock: Double?,
                onStockSelected: (Double?) -> Unit
            ) {
                val title = "Введите запас"
                val dialog = InputDoubleDialog(
                    title = title,
                    startValue = currentStock,
                    isNullable = true,
                    onValueIntroduced = onStockSelected
                )
                showDialog(dialog, context)
            }
        }
    }
}