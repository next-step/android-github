
plugins {
    id("com.android.application") version Versions.gradleVersion apply false
    id("com.android.library") version Versions.gradleVersion apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinVersion apply false
}

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.hiltVersion}")
        classpath(kotlin("gradle-plugin", version = Versions.kotlinVersion))
        classpath(kotlin("serialization", version = Versions.kotlinVersion))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}