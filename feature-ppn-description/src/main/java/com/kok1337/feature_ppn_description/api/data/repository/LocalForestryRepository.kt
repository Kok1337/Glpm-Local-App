package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.model.LocalForestryApiModel
import com.kok1337.feature_ppn_description.api.data.repository.abs.GetRepository

interface LocalForestryRepository : GetRepository<Int, LocalForestryApiModel>