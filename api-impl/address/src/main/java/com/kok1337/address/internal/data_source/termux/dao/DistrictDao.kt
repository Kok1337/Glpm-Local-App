package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.DistrictEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Inject

// TODO table name
internal class DistrictDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getAll(): List<DistrictEntity> {
        val query = "SELECT * FROM public.info_districts;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper)
    }

    fun getById(id: Int): DistrictEntity {
        val query = "SELECT * FROM public.info_districts WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(DistrictEntity::class.java)
    }

    fun getAllWithSearch(search: String): List<DistrictEntity> {
        val query = "SELECT * FROM public.info_districts WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search)
    }

    fun getAllByIdsWithSearch(ids: List<Int>, search: String): List<DistrictEntity> {
        val idsArgs = ids.joinToString(", ", "(", ")") { "?" }
        val query = "SELECT * FROM public.info_districts WHERE id IN $idsArgs AND name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(DistrictEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, ids.toIntArray(), search)
    }
}