package com.kok1337.feature_ppn_taxation.di

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxLayerInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxSpeciesInMemoryRepository
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.species.data.repository.SpeciesFixedRepository
import com.kok1337.taxation.data.repository.*

interface FeaturePpnTaxationFragmentDeps : Dependencies {
    val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository
    val taxationTaxLayerInMemoryRepository: TaxationTaxLayerInMemoryRepository
    val taxationTaxSpeciesInMemoryRepository: TaxationTaxSpeciesInMemoryRepository

    val unforestedLandTermuxRepository: UnforestedLandTermuxRepository
    val nonForestLandTermuxRepository: NonForestLandTermuxRepository
    val forestLandTermuxRepository: ForestPurposeTermuxRepository
    val protectionCategoryTermuxRepository: ProtectionCategoryTermuxRepository
    val bonitetTermuxRepository: BonitetTermuxRepository
    val ozuTermuxRepository: OzuTermuxRepository

    val ageGroupTermuxRepository: AgeGroupTermuxRepository

    val landFixedRepository: LandFixedRepository
    val speciesFixedRepository: SpeciesFixedRepository
}