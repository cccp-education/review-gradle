plugins {
    id("education.cccp.build.gradle-plugin") version "0.0.1"
    id("education.cccp.build.publishing") version "0.0.1"
    id("education.cccp.build.functional-test") version "0.0.1"
    id("education.cccp.build.cucumber") version "0.0.1"
}

group = "education.cccp"
version = libs.plugins.review.get().version

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // Tests unitaires
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.slf4j.api)
    testRuntimeOnly(libs.logback.classic)
    testImplementation(libs.assertj.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.junit.jupiter)

    // Cucumber BDD
    testImplementation(libs.bundles.cucumber)
}

gradlePlugin {
    website.set("https://github.com/cccp-education/review-gradle/")
    vcsUrl.set("https://github.com/cccp-education/review-gradle.git")

    plugins {
        create("review") {
            id = libs.plugins.review.get().pluginId
            implementationClass = "review.ReviewPlugin"
            displayName = "Review Plugin"
            description = "Gradle plugin for AI-assisted code review of pull requests (PR diff analysis, quality score, quality gates, consolidated report)."
            tags.set(listOf("review", "code-review", "pull-request", "ai", "quality-gate", "github"))
        }
    }
}

publishingConventions {
    publicationType = "PLUGIN"
}

publishing {
    repositories {
        mavenCentral()
    }
}