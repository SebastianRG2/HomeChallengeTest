package com.home.challenge.visa.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Pet(
    val id: Int,
    val name: String,
    val category: Category,
    val photoUrls: List<String>,
    val tags: List<Tag>,
    val status: String
)

data class Category(
    val id: Int,
    val name: String
)

data class Tag(
    val id: Int,
    val name: String
)
