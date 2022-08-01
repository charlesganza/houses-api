import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
}

group = "houses"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	//spring core
	val springVersion = "2.7.2"
	implementation("org.springframework.boot:spring-boot-starter-web:$springVersion")
	implementation("org.springframework.boot:spring-boot-starter-security:$springVersion")
	implementation("org.springframework.boot:spring-boot-starter-security:$springVersion")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//hibernate
	implementation("org.hibernate:hibernate-validator:8.0.0.CR1")

	//kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	//coroutines
	val coroutines = "1.6.0"
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$coroutines")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$coroutines")
	//reactive streams
	implementation("org.reactivestreams:reactive-streams:1.0.3")
	//h2 database
	implementation("com.h2database:h2:2.1.210")
	//json parser Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.+")
	//DTO mapper
	implementation("org.mapstruct:mapstruct:1.4.2.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")
	//http client Retrofit and interceptor
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
	testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
	testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
	implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")
	//junit
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("spring-security-starter.jar"))))
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
