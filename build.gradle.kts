// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {

        Kotlin.run {
            classpath(GRADLE_PLUGIN)
        }

        Hilt.run {
            classpath(GRADLE_PLUGIN)
        }

        Classpath.run {
            classpath(GRADLE)
            classpath(KTLINT)
            classpath(ANDROID_JUNIT5)
        }

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
