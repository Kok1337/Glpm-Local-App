package com.kok1337.taxation.domain.model

import java.util.*

data class TaxLayer(
    val id: UUID,
    val parentId: UUID,

    val taxSpeciesList: List<TaxSpecies>,
    val ageGroup: AgeGroup? = null,

    val fullness: Double? = null,
    val stock: Double? = null,
    val ageClass: Int? = null,
    val height: Int? = null,
    val age: Int? = null,
) {
    val composition: String = buildComposition()

    private fun buildComposition(): String {
        val taxSpeciesWithSpeciesList = taxSpeciesList.filter { it.species != null }
        if (taxSpeciesWithSpeciesList.isEmpty()) {
            return ""
        }

        val taxSpeciesWithCoeff = taxSpeciesWithSpeciesList.filter { !it.isExtra }
        val taxSpeciesWithoutCoeff = taxSpeciesWithSpeciesList.filter { it.isExtra }

        val compositionWithCoeff =
            taxSpeciesWithCoeff.joinToString("") { "${it.coeff}${it.species!!.shortName}" }
        val compositionWithoutCoeff =
            taxSpeciesWithoutCoeff.joinToString("+") { it.species!!.shortName }

        if (taxSpeciesWithCoeff.isEmpty()) return compositionWithoutCoeff
        if (taxSpeciesWithoutCoeff.isEmpty()) return compositionWithCoeff
        return "$compositionWithCoeff+$compositionWithoutCoeff"
    }
}