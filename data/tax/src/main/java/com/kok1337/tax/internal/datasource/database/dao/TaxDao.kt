package com.kok1337.tax.internal.datasource.database.dao

import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import com.kok1337.tax.api.TaxApiModel
import com.kok1337.tax.internal.datasource.database.entity.TaxEntity
import org.springframework.jdbc.core.JdbcTemplate
import java.util.UUID

internal class TaxDao(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getById(id: UUID): TaxApiModel {
        val query = "SELECT * FROM public.info_tax WHERE id=? AND is_deleted = false;"
        val entityRowMapper = EntityRowMapper.create(TaxEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)?.toModel()
            ?: throw ItemNotFoundException(TaxEntity::class.java)
    }
}