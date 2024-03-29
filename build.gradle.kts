import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
//    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.emgc"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11



allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "java")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-actuator")
//        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.flywaydb:flyway-core")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
        implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
        runtimeOnly("io.micrometer:micrometer-registry-prometheus")
        runtimeOnly("mysql:mysql-connector-java")
        runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

