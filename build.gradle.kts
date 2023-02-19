plugins {
    kotlin("jvm") version "1.8.10"
    application
}

group = "ru.romalapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.squareup.okhttp3:okhttp:3.10.0")
    implementation ("com.google.code.gson:gson:2.8.9")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("ru.romalapp.presentation.Main")
}