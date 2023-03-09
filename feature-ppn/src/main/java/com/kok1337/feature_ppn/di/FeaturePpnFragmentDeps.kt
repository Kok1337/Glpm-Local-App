package com.kok1337.feature_ppn.di

import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.termux_database.api.DatabaseFactory

interface FeaturePpnFragmentDeps : Dependencies {
    val databaseFactory: DatabaseFactory
}