package com.kok1337.tax_layer_species.internal.datasource.database.dao

import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesApiModel
import com.kok1337.tax_layer_species.api.UserIdProvider
import com.kok1337.tax_layer_species.internal.datasource.database.entity.TaxLayerSpeciesEntity
import org.springframework.jdbc.core.JdbcTemplate
import java.util.*

internal class TaxLayerSpeciesDao constructor(
    private val jdbcTemplate: JdbcTemplate,
    private val userIdProvider: UserIdProvider,
) {
    fun getAllByParentId(parentId: UUID): List<TaxLayerSpeciesApiModel> {
        val query =
            "SELECT * FROM public.info_tax_layer_species WHERE parent_id=? AND is_deleted = false;"
        val entityRowMapper = EntityRowMapper.create(TaxLayerSpeciesEntity::class.java)
        return jdbcTemplate.query(query, entityRowMapper, parentId).map { it.toModel() }
    }

    fun getById(id: UUID): TaxLayerSpeciesApiModel {
        val query = "SELECT * FROM public.info_tax_layer_species WHERE id=? AND is_deleted = false;"
        val entityRowMapper = EntityRowMapper.create(TaxLayerSpeciesEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)?.toModel()
            ?: throw ItemNotFoundException(TaxLayerSpeciesEntity::class.java)
    }

    fun deleteById(id: UUID) {
        val query = "UPDATE public.info_tax_layer_species SET " +
                "user_id=?, is_deleted=true, modification_date=now() WHERE id=?;"
        val userId = userIdProvider.userId
        jdbcTemplate.update(query, userId, id)
    }
}