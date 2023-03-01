package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.LocalityEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import java.util.*
import javax.inject.Inject

class LocalityDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getById(id: UUID): LocalityEntity {
        val query = "SELECT * FROM public.info_locality WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(LocalityEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(LocalityEntity::class.java)
    }

//select DISTINCT region_id from public.info_locality where fo_id=5
}