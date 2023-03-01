package com.kok1337.address

internal fun main() {
    val ids = listOf(
        1, 2, 3, 4,
    )
    val idParams = ids.joinToString(", ", "(", ")") { "?" }
    print(idParams)
}