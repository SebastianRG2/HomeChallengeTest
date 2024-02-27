package com.home.challenge.visa.integrations.requesters.user

import com.home.challenge.visa.utils.ReadFiles
import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import io.restassured.path.json.JsonPath
import org.apache.http.HttpStatus

object CreateUser {
    fun inPetStore() : JsonPath {
        return Requests.post("user")
            .withBasePath(Hosts.BASE_URL)
            .body(ReadFiles.getPayload("create_user"))
            .statusCode(HttpStatus.SC_OK)
            .send()
            .body.jsonPath()
    }
}