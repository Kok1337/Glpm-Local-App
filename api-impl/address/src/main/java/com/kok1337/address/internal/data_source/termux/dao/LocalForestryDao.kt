package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.DistrictEntity
import com.kok1337.address.internal.data_source.termux.entity.LocalForestryEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Inject

// TODO table name
internal class LocalForestryDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getAll(): List<LocalForestryEntity> {
        val query = "SELECT * FROM public.info_regions;"
        val entityRowMapper = EntityRowMapper.create(LocalForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper)
    }

    fun getById(id: Int): LocalForestryEntity {
        val query = "SELECT * FROM public.info_regions WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(LocalForestryEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(LocalForestryEntity::class.java)
    }

    fun getAllWithSearch(search: String): List<LocalForestryEntity> {
        val query = "SELECT * FROM public.info_regions WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(LocalForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search)
    }

    fun getAllByIdsWithSearch(ids: List<Int>, search: String): List<LocalForestryEntity> {
        val idsArgs = ids.joinToString(", ", "(", ")") { "?" }
        val query = "SELECT * FROM public.info_districts WHERE id IN $idsArgs AND name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(LocalForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, ids.toIntArray(), search)
    }
}