/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  java
  application
  id("org.springframework.boot") version "2.1.3.RELEASE"
  id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

private object Versions {
  const val springBoot = "2.1.3.RELEASE"
  const val springBootConfigurationProcessor = "2.1.3.RELEASE"
  const val springCloudDependencies = "Greenwich.SR1"

  const val hikariCP = "3.3.1"
  const val myBatis = "1.3.2"
  const val mysqlConnector = "8.0.15"
  const val lombok = "1.18.4"

  const val springBootTest = "2.1.3.RELEASE"
  const val junit = "5.4.0"
  const val junitCommons = "1.4.0"
  const val junitLauncher = "1.4.0"
  const val mockitoCore = "2.23.4"
  const val mockitoJunit = "2.23.4"
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}")

  implementation("com.zaxxer:HikariCP:${Versions.hikariCP}")
  implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:${Versions.myBatis}")

  implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
  implementation("org.springframework.cloud:spring-cloud-starter-consul-config")

  compileOnly("org.projectlombok:lombok:${Versions.lombok}")
  annotationProcessor("org.projectlombok:lombok:${Versions.lombok}")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${Versions.springBootConfigurationProcessor}")

  runtimeOnly("mysql:mysql-connector-java:${Versions.mysqlConnector}")

  testImplementation("org.springframework.boot:spring-boot-test-autoconfigure:${Versions.springBootTest}")
  testImplementation("org.springframework.boot:spring-boot-test:${Versions.springBootTest}")
  testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
  testImplementation("org.junit.platform:junit-platform-commons:${Versions.junitCommons}")
  testImplementation("org.junit.platform:junit-platform-launcher:${Versions.junitLauncher}")
  testImplementation("org.mockito:mockito-core:${Versions.mockitoCore}")
  testImplementation("org.mockito:mockito-junit-jupiter:${Versions.mockitoJunit}")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloudDependencies}")
  }
}

tasks {
  getByName<Wrapper>("wrapper") {
    gradleVersion = "5.2"
  }
  getByName<BootJar>("bootJar") {
    baseName = "user-service"
    version = ""
    mainClassName = "com.hektorks.UserServiceApplication"
  }
}