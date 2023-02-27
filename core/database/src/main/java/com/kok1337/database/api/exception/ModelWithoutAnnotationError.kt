package com.kok1337.database.api.exception

class ModelWithoutAnnotationError(clazz: Class<*>) :
    Error("${clazz.name} does not have an annotation @Entity")