package com.kok1337.address.internal.data_source.termux.dao

import com.kok1337.address.internal.data_source.termux.entity.LocalityEntity
import com.kok1337.database.api.exception.ItemNotFoundException
import com.kok1337.database.api.mapper.EntityRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.*
import javax.inject.Inject

// TODO table name
internal class LocalityDao @Inject constructor(
    private val jdbcTemplate: JdbcTemplate,
) {
    fun getById(id: UUID): LocalityEntity {
        val query = "SELECT * FROM public.info_locality WHERE id=?;"
        val entityRowMapper = EntityRowMapper.create(LocalityEntity::class.java)
        return jdbcTemplate.queryForObject(query, entityRowMapper, id)
            ?: throw ItemNotFoundException(LocalityEntity::class.java)
    }

    fun getAllDistrictId(): List<Int> {
        val query = "SELECT DISTINCT region_id FROM public.info_locality WHERE fo_id=?;"
        val entityRowMapper = RowMapper { rs: ResultSet, _: Int -> rs.getInt(1) }
        return jdbcTemplate.query(query, entityRowMapper)
    }

    fun getAllRegionIdByDistrictId(districtId: Int): List<Int> {
        val query = "SELECT DISTINCT region_id FROM public.info_locality WHERE fo_id=?;"
        val entityRowMapper = RowMapper { rs: ResultSet, _: Int -> rs.getInt(1) }
        return jdbcTemplate.query(query, entityRowMapper, districtId)
    }

    fun getAllForestryIdByRegionId(regionId: Int): List<Int> {
        val query = "SELECT DISTINCT forestry_id FROM public.info_locality WHERE region_id=?;"
        val entityRowMapper = RowMapper { rs: ResultSet, _: Int -> rs.getInt(1) }
        return jdbcTemplate.query(query, entityRowMapper, regionId)
    }

    fun getAllLocalForestryIdByForestryId(forestryId: Int): List<Int> {
        val query =
            "SELECT DISTINCT localforestry_id FROM public.info_locality WHERE forestry_id=?;"
        val entityRowMapper = RowMapper { rs: ResultSet, _: Int -> rs.getInt(1) }
        return jdbcTemplate.query(query, entityRowMapper, forestryId)
    }

    fun getAllSubForestryIdByLocalForestryId(localForestryId: Int): List<Int> {
        val query =
            "SELECT DISTINCT subforestry_id FROM public.info_locality WHERE localforestry_id=?;"
        val entityRowMapper = RowMapper { rs: ResultSet, _: Int -> rs.getInt(1) }
        return jdbcTemplate.query(query, entityRowMapper, localForestryId)
    }

    fun getByFields(localityEntity: LocalityEntity): LocalityEntity {
        val query = "SELECT * FROM public.info_locality WHERE " +
                "fo_id=? AND region_id=? AND forestry_id=? AND localforestry_id=? AND subforestry_id=? AND area=?;"
        val entityRowMapper = EntityRowMapper.create(LocalityEntity::class.java)
        return jdbcTemplate.queryForObject(
            query,
            entityRowMapper,
            localityEntity,
            localityEntity.districtId,
            localityEntity.regionId,
            localityEntity.forestryId,
            localityEntity.localForestryId,
            localityEntity.subForestryId,
            localityEntity.area
        ) ?: throw ItemNotFoundException(LocalityEntity::class.java)
    }
}