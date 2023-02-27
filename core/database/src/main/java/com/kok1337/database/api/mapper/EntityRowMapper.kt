package com.kok1337.database.api.mapper

import com.kok1337.database.internal.annotationmapper.mapper.EntityAnnotationRowMapper
import org.springframework.jdbc.core.RowMapper

object EntityRowMapper {
    fun <E> create(clazz: Class<E>): RowMapper<E> {
        val entityAnnotationRowMapper = EntityAnnotationRowMapper(clazz)::map
        return RowMapper<E> { resultSet, _ -> entityAnnotationRowMapper.invoke(resultSet) }
    }
}