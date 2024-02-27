package com.home.challenge.visa.integrations.requesters.pet

import com.google.gson.Gson
import com.home.challenge.visa.models.Pet
import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import org.apache.http.HttpStatus

object PetFind {

   fun byId(id : Int) : Pet {
       val responseJson = Requests.get("/pet/$id")
           .withBasePath(Hosts.BASE_URL)
           .statusCode(HttpStatus.SC_OK)
           .send()
           .body.asString()

       val gson = Gson()
       val petType = Pet::class.java
       return gson.fromJson(responseJson, petType)
   }

    fun byBadId(id : Int) : String {
        return Requests.get("/pet/$id")
            .withBasePath(Hosts.BASE_URL)
            .statusCode(HttpStatus.SC_NOT_FOUND)
            .send()
            .body.asString()
    }
}