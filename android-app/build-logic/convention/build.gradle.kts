plugins {
    `kotlin-dsl`
}
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "antstock.plugin.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "antstock.plugin.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "antstock.plugin.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "antstock.plugin.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("feature") {
            id = "antstock.plugin.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("hilt") {
            id = "antstock.plugin.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    compileOnly(libs.gradle.plugin.agp)
    compileOnly(libs.gradle.plugin.kotlin)
    compileOnly(libs.gradle.plugin.ksp)
}