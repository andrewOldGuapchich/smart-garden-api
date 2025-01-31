plugins {
    kotlin("jvm") version "2.0.10"
    `maven-publish`
}

publishing{
    repositories {
        maven {
            url =  uri("http://localhost:8081/repository/smart_garden")
            credentials {
                username = project.findProperty("nexus.name") as String? ?: ""
                password = project.findProperty("nexus.password") as String? ?: ""
            }
        }
    }
}

group = "com.andrew.smart_garden"
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