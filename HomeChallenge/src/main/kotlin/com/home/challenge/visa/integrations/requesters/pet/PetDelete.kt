package com.home.challenge.visa.integrations.requesters.pet

import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import org.apache.http.HttpStatus

object PetDelete {
    fun byId(id: Int): String {
        return Requests.delete("/pet/$id")
            .withBasePath(Hosts.BASE_URL)
            .statusCode(HttpStatus.SC_OK)
            .send()
            .body().asString()
    }
}