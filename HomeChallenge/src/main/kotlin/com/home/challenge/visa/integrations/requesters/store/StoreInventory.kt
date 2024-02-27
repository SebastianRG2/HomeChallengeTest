package com.home.challenge.visa.integrations.requesters.store

import com.home.challenge.visa.utils.GenericUtils
import com.home.challenge.visa.utils.ReadFiles
import com.home.challenge.visa.utils.Requests
import com.home.challenge.visa.utils.constants.Hosts
import io.restassured.path.json.JsonPath
import org.apache.http.HttpStatus

object StoreInventory {
    fun checkStatusIventory(status: String): Int {
        return Requests.get("/store/inventory")
            .withBasePath(Hosts.BASE_URL)
            .statusCode(HttpStatus.SC_OK)
            .send()
            .body.jsonPath().getInt(status)
    }

    fun placeNewOrderForPet(status: String) {
        val value = mutableMapOf<String, String>(
            "status" to status
        )
        Requests.post("/store/order")
            .withBasePath(Hosts.BASE_URL)
            .body(GenericUtils.editPayload(ReadFiles.getPayload("order_store"), value))
            .statusCode(HttpStatus.SC_OK)
            .send()
    }
}