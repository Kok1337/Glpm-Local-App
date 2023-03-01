package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.RegionEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Inject

class RegionDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getAll(): List<RegionEntity> {
        val query = "SELECT * FROM public.info_regions;"
        val entityRowMapper = EntityRowMapper.create(RegionEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper)
    }

    fun getById(id: Int): RegionEntity {
        val query = "SELECT * FROM public.info_regions WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(RegionEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(RegionEntity::class.java)
    }

    fun getAllWithSearch(search: String): List<RegionEntity> {
        val query = "SELECT * FROM public.info_regions WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(RegionEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search)
    }
}