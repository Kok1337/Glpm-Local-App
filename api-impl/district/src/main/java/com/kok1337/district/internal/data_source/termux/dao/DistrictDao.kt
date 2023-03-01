package com.kok1337.district.internal.data_source.termux.dao

import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import com.kok1337.district.api.module.District
import com.kok1337.district.internal.data_source.termux.entity.DistrictEntity
import com.kok1337.district.internal.data_source.termux.mapper.EntityMapper
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Inject

class DistrictDao @Inject constructor(private val jdbcTemplate: JdbcTemplate) {
    fun getAll(): List<District> {
        val query = "SELECT * FROM public.info_districts;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper).map(EntityMapper::map)
    }

    fun getById(id: Int): District {
        val query = "SELECT * FROM public.info_districts WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)?.let(EntityMapper::map)
            ?: throw ItemNotFoundException(DistrictEntity::class.java)
    }

    fun getWithSearch(search: String): List<District> {
        val query = "SELECT * FROM public.info_districts WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search).map(EntityMapper::map)
    }
}