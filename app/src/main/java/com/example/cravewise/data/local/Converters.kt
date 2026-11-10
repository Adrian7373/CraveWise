package com.example.cravewise.data.local

import androidx.room.TypeConverter
import com.example.cravewise.domain.model.Allergen
import com.example.cravewise.domain.model.ContainsFlag
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

/**
 * Room converters. Collections are stored as JSON using the enums' @SerialName values, so the
 * database speaks the same vocabulary as the seed files. Single enums use Room's built-in
 * name-based conversion.
 */
class Converters {
    private val json = Json

    @TypeConverter
    fun stringsToJson(value: List<String>): String = json.encodeToString(ListSerializer(String.serializer()), value)

    @TypeConverter
    fun jsonToStrings(value: String): List<String> = json.decodeFromString(ListSerializer(String.serializer()), value)

    @TypeConverter
    fun allergensToJson(value: Set<Allergen>): String = json.encodeToString(SetSerializer(Allergen.serializer()), value)

    @TypeConverter
    fun jsonToAllergens(value: String): Set<Allergen> = json.decodeFromString(SetSerializer(Allergen.serializer()), value)

    @TypeConverter
    fun containsToJson(value: Set<ContainsFlag>): String = json.encodeToString(SetSerializer(ContainsFlag.serializer()), value)

    @TypeConverter
    fun jsonToContains(value: String): Set<ContainsFlag> = json.decodeFromString(SetSerializer(ContainsFlag.serializer()), value)
}
