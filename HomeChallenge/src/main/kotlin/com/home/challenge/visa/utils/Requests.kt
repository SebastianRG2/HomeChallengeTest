package com.home.challenge.visa.utils

import io.restassured.config.DecoderConfig
import io.restassured.config.HttpClientConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.http.ContentType
import io.restassured.response.Response
import net.serenitybdd.rest.SerenityRest

object Requests {

    @JvmStatic
    fun post(url: String): RequestBuilder {
        return RequestBuilder("POST", url)
    }

    @JvmStatic
    fun get(url: String): RequestBuilder {
        return RequestBuilder("GET", url)
    }

    @JvmStatic
    fun put(url: String): RequestBuilder {
        return RequestBuilder("PUT", url)
    }

    @JvmStatic
    fun delete(url: String): RequestBuilder {
        return RequestBuilder("DELETE", url)
    }

    class RequestBuilder(private val method: String, private val url: String) {
        private var basePath: String = ""
        private var headers: MutableMap<String, Any>? = null
        private var body: Any? = null
        private var params: MutableMap<String, Any>? = null
        private var statusCode: Int = 0

        fun withBasePath(basePath: String): RequestBuilder {
            this.basePath = basePath
            return this
        }

        fun headers(headers: MutableMap<String, Any>): RequestBuilder {
            this.headers = headers
            return this
        }

        fun body(body: Any): RequestBuilder {
            this.body = body
            return this
        }

        fun params(params: MutableMap<String, Any>): RequestBuilder {
            this.params = params
            return this
        }

        fun statusCode(statusCode: Int): RequestBuilder {
            this.statusCode = statusCode
            return this
        }

        fun send(): Response {

            require(basePath.isNotEmpty()) { "You must specify a base URL before calling send()" }
            require(url.isNotEmpty()) { "You must specify a endpoint before calling send()" }
            require(statusCode != 0) { "You must specify a status code before calling send()" }

            val config = RestAssuredConfig.config().httpClient(
                HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 2000)
            ).decoderConfig(DecoderConfig.decoderConfig().useNoWrapForInflateDecoding(true))

            SerenityRest.setDefaultConfig(config)

            val request = SerenityRest.given()
                .baseUri(basePath)
                .log()
                .all()
                .contentType(ContentType.JSON)

            if (headers != null) {
                request.headers(headers)
            }

            if (body != null) {
                request.body(body)
            }

            if (params != null) {
                request.params(params)
            }

            request.`when`().then().log().all().statusCode(statusCode)

            val response = when (method) {
                "POST" -> request.post(url)
                "GET" -> request.get(url)
                "PUT" -> request.put(url)
                "DELETE" -> request.delete(url)
                else -> throw IllegalArgumentException("Invalid HTTP method: $method")
            }

            return response
        }
    }
}