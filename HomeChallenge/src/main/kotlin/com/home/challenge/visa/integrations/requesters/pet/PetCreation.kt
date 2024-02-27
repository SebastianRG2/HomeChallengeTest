package com.home.challenge.visa.integrations.requesters.pet

import com.google.gson.Gson
import com.home.challenge.visa.models.Pet
import com.home.challenge.visa.utils.GenericUtils
import com.home.challenge.visa.utils.ReadFiles
import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import org.apache.http.HttpStatus

object PetCreation {

    fun inStore(id: Int): Pet {
        val value = mutableMapOf<String, Int>(
            "id" to id
        )
        val responseJson = Requests.post("/pet")
            .withBasePath(Hosts.BASE_URL)
            .body(GenericUtils.editPayload(ReadFiles.getPayload("pet_request"), value))
            .statusCode(HttpStatus.SC_OK)
            .send()
            .body.asString()

        val gson = Gson()
        val petType = Pet::class.java
        return gson.fromJson(responseJson, petType)
    }
}