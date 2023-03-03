package com.kok1337.feature_ppn_description.api

import com.kok1337.providing_dependencies.Dependencies

interface PpnDescriptionDeps : Dependencies  {
    val databaseFactory: DatabaseFactory
}