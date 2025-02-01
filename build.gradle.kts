plugins {
    kotlin("jvm") version "2.0.10"
    `maven-publish`
}

publishing{
    publications{
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "smart-garden-api"
            version = "1.0.2"
        }
    }
    repositories {
        maven {
            url =  uri("http://localhost:8081/repository/smart_garden/")
            isAllowInsecureProtocol = true
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
