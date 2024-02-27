package com.home.challenge.visa.stepdefinitions.hooks

import com.home.challenge.visa.utils.SerenitySession
import io.cucumber.java.BeforeAll

object SessionHook {
    @JvmStatic
    @BeforeAll(order = 0)
    fun startSession() {
        SerenitySession.createActor()
    }
}