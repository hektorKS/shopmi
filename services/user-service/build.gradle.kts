import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  java
  application
  id("org.springframework.boot") version "2.1.3.RELEASE"
  id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

private object Versions {
  const val springCloudVersion = "Greenwich.SR1"
  const val lombok = "1.18.2"
  const val junit = "5.1.0"
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {

  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.cloud:spring-cloud-starter-consul-all")
  compileOnly("org.projectlombok:lombok:${Versions.lombok}")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junit}")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit}")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencyManagement {
  imports { mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloudVersion}") }
}

tasks {
  getByName<Wrapper>("wrapper") {
    gradleVersion = "5.2"
  }
  getByName<BootJar>("bootJar") {
    baseName = "user-service"
    version = ""
    mainClassName = "com.hektorks.userservice.UserServiceApplication"
  }
}