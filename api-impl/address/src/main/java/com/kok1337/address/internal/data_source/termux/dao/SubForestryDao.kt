package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.SubForestryEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Inject

// TODO table name
internal class SubForestryDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getAll(): List<SubForestryEntity> {
        val query = "SELECT * FROM public.info_regions;"
        val entityRowMapper = EntityRowMapper.create(SubForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper)
    }

    fun getById(id: Int): SubForestryEntity {
        val query = "SELECT * FROM public.info_regions WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(SubForestryEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(SubForestryEntity::class.java)
    }

    fun getAllWithSearch(search: String): List<SubForestryEntity> {
        val query = "SELECT * FROM public.info_regions WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(SubForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search)
    }

    fun getAllByIdsWithSearch(ids: List<Int>, search: String): List<SubForestryEntity> {
        val idsArgs = ids.joinToString(", ", "(", ")") { "?" }
        val query = "SELECT * FROM public.info_districts WHERE id IN $idsArgs AND name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(SubForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, ids.toIntArray(), search)
    }
}