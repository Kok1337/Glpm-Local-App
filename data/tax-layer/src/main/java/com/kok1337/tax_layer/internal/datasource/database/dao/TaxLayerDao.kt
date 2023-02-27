package com.kok1337.tax_layer.internal.datasource.database.dao

import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import com.kok1337.tax_layer.api.TaxLayerApiModel
import com.kok1337.tax_layer.internal.datasource.database.entity.TaxLayerEntity
import org.springframework.jdbc.core.JdbcTemplate
import java.util.*

internal class TaxLayerDao(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getById(id: UUID): TaxLayerApiModel {
        val query = "SELECT * FROM from public.info_tax_layer WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(TaxLayerEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)?.toModel()
            ?: throw ItemNotFoundException(TaxLayerEntity::class.java)
    }

    fun getAllByParentId(parentId: UUID): List<TaxLayerApiModel> {
        val query = "SELECT * FROM from public.info_tax_layer WHERE parent_id=?;"
        val entityRowMapper = EntityRowMapper.create(TaxLayerEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, parentId).map { it.toModel() }
    }
}