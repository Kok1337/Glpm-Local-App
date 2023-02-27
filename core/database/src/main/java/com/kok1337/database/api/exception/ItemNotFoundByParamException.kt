package com.kok1337.database.api.exception

class ItemNotFoundByParamException(clazz: Class<*>, paramName: String, paramValue: Any) :
    Exception("Item ${clazz.name} with $paramName=$paramValue not found.")