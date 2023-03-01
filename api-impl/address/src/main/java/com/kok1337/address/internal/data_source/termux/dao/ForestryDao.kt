package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.ForestryEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Inject

class ForestryDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getAll(): List<ForestryEntity> {
        val query = "SELECT * FROM public.info_districts;"
        val entityRowMapper = EntityRowMapper.create(ForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper)
    }

    fun getById(id: Int): ForestryEntity {
        val query = "SELECT * FROM public.info_districts WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(ForestryEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(ForestryEntity::class.java)
    }

    fun getAllWithSearch(search: String): List<ForestryEntity> {
        val query = "SELECT * FROM public.info_districts WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(ForestryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search)
    }
}