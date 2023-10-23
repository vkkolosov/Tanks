plugins {
    id("java")
    id ("application")
    id ("org.openjfx.javafxplugin") version "0.1.0"
}

group = "own.game"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

javafx {
    version = "21.0.1"
    modules = mutableListOf("javafx.controls")
}