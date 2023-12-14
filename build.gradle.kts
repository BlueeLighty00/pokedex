// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
//TODO usamos la última versión de kotlin
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
//TODO añadimos el plugin de ksp
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}

buildscript {
    dependencies {
        val hiltVersion = "2.48.1" // Reemplazar con la versión más reciente
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}