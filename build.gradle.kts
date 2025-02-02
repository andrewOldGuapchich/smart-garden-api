plugins {
    kotlin("jvm") version "2.0.10"
    id("pl.allegro.tech.build.axion-release") version "1.15.0"
    `maven-publish`
}

scmVersion {
    tag {
        prefix = "v"
    }
    versionIncrementer("incrementMinor")
    hooks{
        pre("fileUpdate", mapOf("files" to listOf("README.md"))) // Обновляет версию в файлах
        pre("commit")
    }
}

group = "com.andrew.smart_garden"
version = scmVersion.version

publishing{
    publications{
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "smart-garden-api"
            version = "1.0.1"
        }
    }
    repositories {
        maven {
            url =  uri("http://localhost:8081/repository/smart_garden/")
            isAllowInsecureProtocol = true
            credentials {
                username = "admin"//project.findProperty("nexus.name") as String? ?: ""
                password = "Andrew5525613"//project.findProperty("nexus.password") as String? ?: ""
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}