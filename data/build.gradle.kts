import Versions.Hilt.hiltVersion
import Versions.KotlinX.coroutineVersion
import Versions.Retrofit.moshiVersion
import Versions.Retrofit.retrofitVersion
import Versions.Test.archCoreTestingVersion
import Versions.Test.junitVersion
import Versions.Test.mockWebServerVersion
import Versions.Test.truthVersion

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id ("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
dependencies {
    implementation(project(":domain"))

    //힐트
    kapt ("com.google.dagger:hilt-compiler:$hiltVersion")
    implementation ("com.google.dagger:hilt-core:$hiltVersion")

    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    implementation("com.squareup.moshi:moshi-adapters:$moshiVersion")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")

    implementation("junit:junit:$junitVersion")

    testImplementation("com.squareup.okhttp3:mockwebserver:$mockWebServerVersion")
    testImplementation("com.google.truth:truth:$truthVersion")
    testImplementation("androidx.arch.core:core-testing:$archCoreTestingVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")
}
