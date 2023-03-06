package com.kok1337.feature_ppn_description_sample.di

import com.kok1337.feature_ppn_description.api.data.data_source.termux.DatabaseFactory
import com.kok1337.providing_dependencies.Dependencies


interface PpnDescriptionActivityDeps : Dependencies {
    val databaseFactory: DatabaseFactory
}