plugins {
    id("antstock.plugin.android.application")
    id("antstock.plugin.android.application.compose")
    alias(libs.plugins.kotlin.ksp)
    id("antstock.plugin.hilt")
}

android {
    namespace = "com.anotn.antstock.android_app"

    defaultConfig {
        applicationId = "com.anotn.antstock.android_app"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":feature:home"))
    implementation(project(":feature:market"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.splash.screen)

    implementation(libs.apollo.runtime)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}