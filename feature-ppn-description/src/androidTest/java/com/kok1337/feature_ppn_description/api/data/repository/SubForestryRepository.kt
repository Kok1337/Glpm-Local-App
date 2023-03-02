package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.model.SubForestryApiModel
import com.kok1337.feature_ppn_description.api.data.repository.abs.GetRepository

interface SubForestryRepository : GetRepository<Int, SubForestryApiModel>