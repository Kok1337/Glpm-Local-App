package com.kok1337.feature_ppn_description.api

import org.ktorm.database.Database

interface DatabaseFactory {
    fun create(): Database
}