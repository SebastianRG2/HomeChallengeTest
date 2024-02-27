object Versions {
    const val SERENITY = "4.0.30"
}

plugins {
    id("java-library")
    id("idea")
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.0.30"
    kotlin("jvm") version "1.9.10"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    api("net.serenity-bdd:serenity-screenplay:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-core:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-junit:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-cucumber:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-rest-assured:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-ensure:${Versions.SERENITY}")
    api("net.serenity-bdd:serenity-screenplay-rest:${Versions.SERENITY}")
    api("com.googlecode.json-simple:json-simple:1.1.1")
    api("com.jayway.jsonpath:json-path:2.9.0")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    api("de.vandermeer:asciitable:0.3.2")
    api("org.slf4j:slf4j-simple:2.0.12")
    api("org.apache.logging.log4j:log4j-core:2.23.0")
}

serenity {
    testRoot = "HomeChallenge"
    requirementsBaseDir = "src/test/resources/features"
}
