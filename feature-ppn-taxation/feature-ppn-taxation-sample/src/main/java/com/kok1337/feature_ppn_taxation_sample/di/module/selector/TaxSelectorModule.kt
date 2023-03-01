package com.kok1337.feature_ppn_taxation_sample.di.module.selector

import android.content.Context
import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.bonitet.api.use_case.GetAllBonitetBySearchUseCase
import com.kok1337.dialog.presentation.dialog.InputStringDialog
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxSelector
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.BonitetUseCaseModule
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.ForestPurposeUseCaseModule
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.NonForestLandUseCaseModule
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.OzuUseCaseModule
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.ProtectionCategoryUseCaseModule
import com.kok1337.feature_ppn_taxation_sample.di.module.use_case.UnforestedLandUseCaseModule
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.forest_purpose.api.use_case.GetAllForestPurposeBySearchUseCase
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.non_forest_land.api.use_case.GetAllNonForestLandBySearchUseCase
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.ozu.api.use_case.GetAllOzuBySearchUseCase
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.protection_category.api.use_case.GetAllProtectionCategoryBySearchUseCase
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.searchable_spinner.presentation.dialog.SimpleSearchableSpinnerDialog
import com.kok1337.unforested_land.api.model.UnforestedLand
import com.kok1337.unforested_land.api.use_case.GetAllUnforestedLandBySearchUseCase
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        UnforestedLandUseCaseModule::class,
        NonForestLandUseCaseModule::class,
        ForestPurposeUseCaseModule::class,
        ProtectionCategoryUseCaseModule::class,
        BonitetUseCaseModule::class,
        OzuUseCaseModule::class
    ]
)
internal interface TaxSelectorModule {
    companion object {
        @Provides
        fun taxSelector(
            context: Context,
            getAllUnforestedLandBySearchUseCase: GetAllUnforestedLandBySearchUseCase,
            getAllNonForestLandBySearchUseCase: GetAllNonForestLandBySearchUseCase,
            getAllForestPurposeBySearchUseCase: GetAllForestPurposeBySearchUseCase,
            getAllProtectionCategoryBySearchUseCase: GetAllProtectionCategoryBySearchUseCase,
            getAllBonitetBySearchUseCase: GetAllBonitetBySearchUseCase,
            getAllOzuBySearchUseCase: GetAllOzuBySearchUseCase,
        ): TaxSelector = object : TaxSelector {
            override suspend fun selectUnforestedLand(
                currentUnforestedLand: UnforestedLand?,
                onUnforestedLandSelected: (UnforestedLand?) -> Unit
            ) {
                val title = "Выберите лесные земли"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllUnforestedLandBySearchUseCase(search)
                }
                val itemToText = { item: UnforestedLand -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentUnforestedLand,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onUnforestedLandSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectNonForestLand(
                currentNonForestLand: NonForestLand?,
                onNonForestLandSelected: (NonForestLand?) -> Unit
            ) {
                val title = "Выберите не лесные земли"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllNonForestLandBySearchUseCase(search)
                }
                val itemToText = { item: NonForestLand -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentNonForestLand,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onNonForestLandSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectForestPurpose(
                currentForestPurpose: ForestPurpose?,
                onForestPurposeSelected: (ForestPurpose?) -> Unit
            ) {
                val title = "Выберите целевое назначение"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllForestPurposeBySearchUseCase(search)
                }
                val itemToText = { item: ForestPurpose -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentForestPurpose,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onForestPurposeSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectProtectionCategory(
                currentProtectionCategory: ProtectionCategory?,
                onProtectionCategorySelected: (ProtectionCategory?) -> Unit
            ) {
                val title = "Выберите категорию защитности"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllProtectionCategoryBySearchUseCase(search)
                }
                val itemToText = { item: ProtectionCategory -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentProtectionCategory,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onProtectionCategorySelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectBonitet(
                currentBonitet: Bonitet?,
                onBonitetSelected: (Bonitet?) -> Unit
            ) {
                val title = "Выберите бонитет"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllBonitetBySearchUseCase(search)
                }
                val itemToText = { item: Bonitet -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentBonitet,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onBonitetSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectForestType(
                currentForestType: String?,
                onForestTypeSelected: (String?) -> Unit
            ) {
                val title = "Введите тип леса"
                val dialog = InputStringDialog(
                    title = title,
                    startValue = currentForestType,
                    isNullable = true,
                    onValueIntroduced = onForestTypeSelected
                )
                showDialog(dialog, context)
            }

            override suspend fun selectOzu(currentOzu: Ozu?, onOzuSelected: (Ozu?) -> Unit) {
                val title = "Выберите бонитет"
                val repository = SearchableSpinnerRepository { search, _ ->
                    getAllOzuBySearchUseCase(search)
                }
                val itemToText = { item: Ozu -> item.name }
                val dialog = SimpleSearchableSpinnerDialog(
                    title = title,
                    selectedItem = currentOzu,
                    searchableSpinnerRepository = repository,
                    itemToTextTransformation = itemToText,
                    onItemSelected = onOzuSelected
                )
                showDialog(dialog, context)
            }
        }
    }
}