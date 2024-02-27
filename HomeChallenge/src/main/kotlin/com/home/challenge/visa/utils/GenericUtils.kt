package com.home.challenge.visa.utils

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.spi.json.GsonJsonProvider
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider

object GenericUtils {

    @JvmStatic
    fun editPayload(payload: String, fields: Map<String, Any?>): String {
        val configuration = Configuration.builder()
            .jsonProvider(GsonJsonProvider())
            .mappingProvider(GsonMappingProvider())
            .build()

        val document = JsonPath.using(configuration).parse(payload)

        for ((fieldPath, newValue) in fields) {
            document.set(fieldPath, newValue)
        }

        return if (payload.first() == '[') {
            document.json<JsonArray>().toString()
        } else {
            document.json<JsonObject>().toString()
        }
    }
}