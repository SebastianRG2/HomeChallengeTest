package com.home.challenge.visa.utils

import java.io.BufferedReader
import java.io.InputStreamReader

object ReadFiles {
    private const val JSON_EXTENSION = ".json"

    @JvmStatic
    fun getPayload(fileName: String): String {

        val filePath = "/payloads/$fileName$JSON_EXTENSION"
        val inputStream = ReadFiles::class.java.getResourceAsStream(filePath)
            ?: throw IllegalArgumentException("File '$fileName' not found!")

        return BufferedReader(InputStreamReader(inputStream)).use { it.readText() }
    }

}