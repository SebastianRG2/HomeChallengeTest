package com.home.challenge.visa.integrations.requesters.user

import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import org.apache.http.HttpStatus

object LoginUser {
    fun inPetStoreService(): String {
        return Requests.get("user/login")
            .withBasePath(Hosts.BASE_URL)
            .statusCode(HttpStatus.SC_OK)
            .send()
            .body().asString()
    }
}