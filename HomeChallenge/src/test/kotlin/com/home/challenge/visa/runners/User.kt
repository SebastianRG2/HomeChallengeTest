package com.home.challenge.visa.runners

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    glue = ["com.home.challenge.visa.stepdefinitions"],
    features = ["src/test/resources/features/user.feature"],
    snippets = CucumberOptions.SnippetType.CAMELCASE)
class User