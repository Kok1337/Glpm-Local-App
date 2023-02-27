package com.kok1337.dictionary.api

import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class DictionaryDao<M>(
    private val jdbcTemplate: JdbcTemplate,
    private val tableName: String,
    private val mapper: (DictionaryEntity) -> M
) {
    fun getAll(): List<M> {
        val query = "SELECT * FROM public.$tableName;"
        val entityRowMapper = EntityRowMapper.create(DictionaryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper).map(mapper)
    }

    fun getById(id: Int): M {
        val query = "SELECT * FROM public.$tableName WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(DictionaryEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)?.let(mapper)
            ?: throw ItemNotFoundException(DictionaryEntity::class.java)
    }

    fun getWithSearch(search: String): List<M> {
        val query = "SELECT * FROM public.$tableName WHERE name ~* ?;"
        val entityRowMapper = EntityRowMapper.create(DictionaryEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, search).map(mapper)
    }
}