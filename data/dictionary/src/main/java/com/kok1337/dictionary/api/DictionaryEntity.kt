package com.kok1337.dictionary.api

import com.kok1337.database.api.annotation.Column
import com.kok1337.database.api.annotation.Entity

@Entity
class DictionaryEntity(
    @Column("id") var id: Int? = null,
    @Column("name") var name: String? = null,
)