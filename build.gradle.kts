import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*;
import org.springframework.boot.gradle.tasks.bundling.*;
import org.gradle.jvm.tasks.Jar

buildscript {
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        val kotlinVersion = "1.5.21";
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.6.2")
        classpath("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    }

}

plugins {
    kotlin("jvm") version "1.6.0-RC2"
    java
    id("com.google.protobuf") version "0.8.13"
//    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("maven-publish")

//    id("kotlin")
    id ("org.jetbrains.kotlin.plugin.spring") version "1.3.41"
    id ("org.jetbrains.kotlin.plugin.jpa")  version "1.3.41"
    id("java-library")
    id ("org.springframework.boot") version "2.1.6.RELEASE"
    id ("io.spring.dependency-management") version "1.0.7.RELEASE"
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "jadoo-common"
            url = uri("https://maven.pkg.github.com/8721son/jadoo-common")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
group = "com.github.8721son"
version = "1.1.1"
java.sourceCompatibility = JavaVersion.VERSION_17

val jar: Jar by tasks
val bootJar: BootJar by tasks
bootJar.enabled = false


dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}


repositories{
    mavenCentral()
    google()
}

val springCloudVersion = "2021.0.0"
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

dependencies {

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compileOnly("javax.annotation:javax.annotation-api:1.3.2")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.cloud:spring-cloud-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-bus-amqp")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")


    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testCompileOnly ("org.projectlombok:lombok:1.18.20")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.20")

    implementation("org.springframework.cloud:spring-cloud-starter-oauth2:2.2.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jar {
    enabled = true
    // Remove `plain` postfix from jar file name
    archiveClassifier.set("")
}