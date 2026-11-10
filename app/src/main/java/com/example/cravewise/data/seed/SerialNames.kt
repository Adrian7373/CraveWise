package com.example.cravewise.data.seed

import kotlinx.serialization.KSerializer

/** The @SerialName of an enum value, e.g. `Allergen.TreeNuts` -> "tree_nuts". */
internal fun <T : Enum<T>> KSerializer<T>.serialNameOf(value: T): String =
    descriptor.getElementName(value.ordinal)

/** Reverse of [serialNameOf]; null for unknown names (e.g. a value removed in a newer build). */
internal fun <T : Enum<T>> KSerializer<T>.fromSerialName(name: String, entries: List<T>): T? =
    descriptor.getElementIndex(name).takeIf { it >= 0 }?.let(entries::get)
