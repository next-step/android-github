plugins {
    id("com.android.application") version gradleVersion apply false
    id("com.android.library") version gradleVersion apply false
    id("org.jetbrains.kotlin.android") version kotlinVersion apply false
}

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}