package com.kok1337.database.api.exception

class ItemNotFoundException(clazz: Class<*>) :
    Exception("Item ${clazz.name} not found.")