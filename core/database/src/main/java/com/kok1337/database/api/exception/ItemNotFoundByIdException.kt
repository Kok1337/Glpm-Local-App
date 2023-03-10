package com.kok1337.database.api.exception

class ItemNotFoundByIdException(clazz: Class<*>, id: Any) :
    Exception("Item ${clazz.name} with id=$id not found.")