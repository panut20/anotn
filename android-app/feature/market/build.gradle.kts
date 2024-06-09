plugins {
    id("antstock.plugin.feature")
    id("antstock.plugin.hilt")
}

android {
    namespace = "com.anotn.antstock.market"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}