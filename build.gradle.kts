import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
    kotlin("plugin.allopen") version "1.9.22"
    kotlin("plugin.noarg") version "1.9.22"
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
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("org.jetbrains.kotlin.plugin.noarg")
    }

    extra["springCloudVersion"] = "2023.0.0"

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")
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
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        testImplementation("io.projectreactor:reactor-test")
    }
    val bootJar: BootJar by tasks
    bootJar.mainClass.set("com.foresty.api.ForestyApiApplication")

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

project("foresty-domain") {
    val exposedVersion: String by project
    val querydslVersion: String by project
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
        compileOnly("org.projectlombok:lombok")
        implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")

        implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-money:$exposedVersion")
        implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")

        // querydsl
        implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
        annotationProcessor("com.querydsl:querydsl-apt:$querydslVersion:jakarta")
        annotationProcessor("jakarta.annotation:jakarta.annotation-api")
        annotationProcessor("jakarta.persistence:jakarta.persistence-api")
        annotationProcessor("org.projectlombok:lombok")
        runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
        //runtimeOnly("org.mariadb:r2dbc-mariadb")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
    allOpen {
        annotation("jakarta.persistence.Entity")
        annotation("jakarta.persistence.MappedSuperclass")
        annotation("jakarta.persistence.Embeddable")
    }

    noArg {
        annotation("jakarta.persistence.Entity")
        annotation("jakarta.persistence.MappedSuperclass")
        annotation("jakarta.persistence.Embeddable")
    }

    val bootJar: BootJar by tasks
    val jar: Jar by tasks

    bootJar.enabled = false
    jar.enabled = true
    val querydslSrcDir: String = "src/main/generated"

    tasks.clean {
        delete(file(querydslSrcDir))
    }

    tasks.withType<JavaCompile> {
        options.generatedSourceOutputDirectory = file(querydslSrcDir)
    }
}

tasks.wrapper {
    gradleVersion="8.5"
}