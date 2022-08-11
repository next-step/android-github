import Versions.Hilt.javaxInjectVersion
import Versions.KotlinX.coroutineVersion
import Versions.Test.junitVersion

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
    //힐트
    implementation ("javax.inject:javax.inject:$javaxInjectVersion")

    //coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

    implementation("junit:junit:$junitVersion")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")

}