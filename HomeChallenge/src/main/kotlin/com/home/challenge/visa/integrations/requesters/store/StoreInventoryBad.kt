package com.home.challenge.visa.integrations.requesters.store

import com.home.challenge.visa.utils.ReadFiles
import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import org.apache.http.HttpStatus

object StoreInventoryBad {
    fun requestInput(): String {
        return Requests.put("/store/order")
            .withBasePath(Hosts.BASE_URL)
            .body(ReadFiles.getPayload("order_store"))
            .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
            .send()
            .body.jsonPath().getString("message")
    }
}