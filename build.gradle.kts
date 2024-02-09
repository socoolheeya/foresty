import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
//    kotlin("plugin.jpa") version "1.9.22"
//    kotlin("plugin.allopen") version "1.9.22"
//    kotlin("plugin.noarg") version "1.9.22"
}

tasks.withType<BootJar> {
    enabled = false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = "com.foresty"
    version = "0.0.1-SNAPSHOT"

    apply {
        plugin("java")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
//        plugin("org.jetbrains.kotlin.plugin.jpa")
//        plugin("org.jetbrains.kotlin.plugin.noarg")
    }

    extra["springCloudVersion"] = "2023.0.0"

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
//        implementation("org.springframework.boot:spring-boot-starter-web")
//        implementation("org.springframework.boot:spring-boot-starter-validation")
//        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//        implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

//        runtimeOnly("com.h2database:h2")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "21"
        }
    }
}

project("foresty-api") {
    dependencies {
        implementation(project(path = ":foresty-domain", configuration = "default"))
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
        implementation("org.springframework.boot:spring-boot-starter-web")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
    }
    val bootJar: BootJar by tasks
    bootJar.mainClass.set("com.foresty.api.ForestyApiApplication")

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

project("foresty-domain") {
    val exposedVersion: String by project
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
//        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//        implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
        compileOnly("org.projectlombok:lombok")
        implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

        implementation("org.jetbrains.exposed:exposed-jodatime:$exposedVersion")
        // or
        implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
        // or
        implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")

        implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-money:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
        annotationProcessor("org.projectlombok:lombok")
        //runtimeOnly("com.h2database:h2")
        runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    }
//    allOpen {
//        annotation("jakarta.persistence.Entity")
//        annotation("jakarta.persistence.MappedSuperclass")
//        annotation("jakarta.persistence.Embeddable")
//    }
//
//    noArg {
//        annotation("jakarta.persistence.Entity")
//        annotation("jakarta.persistence.MappedSuperclass")
//        annotation("jakarta.persistence.Embeddable")
//    }


    val bootJar: BootJar by tasks
    val jar: Jar by tasks

    bootJar.enabled = false
    jar.enabled = true

//    val generated = "src/main/generated"
//    tasks.withType<JavaCompile>().configureEach {
//        options.generatedSourceOutputDirectory.set(file(generated))
//    }
}

tasks.wrapper {
    gradleVersion="8.5"
}