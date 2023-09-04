plugins {
	id("kotlin")
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	implementation(project(":domain"))

	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.okhttp3:okhttp:4.9.3")
	implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

	testImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
	testImplementation("junit:junit:4.13.2")
	testImplementation("com.google.truth:truth:1.1.3")
}