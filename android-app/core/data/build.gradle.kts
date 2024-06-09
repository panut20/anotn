plugins {
    id("antstock.plugin.android.library")
    id("antstock.plugin.hilt")

    alias(libs.plugins.apollo)
}

android {
    namespace = "com.anotn.antstock.data"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.apollo.runtime)

    androidTestImplementation(libs.androidx.espresso.core)
}