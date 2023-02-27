package com.kok1337.database.api.exception

class NoEmptyConstructorError(clazz: Class<*>) :
    Error("${clazz.name} does not have an empty constructor")