plugins {
    kotlin("jvm") version "2.1.10"
}

group = "com.github.pedroluis02.mydigitalwallet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}