plugins {
    id("antstock.plugin.android.library")
    id("antstock.plugin.android.library.compose")

}

android {
    namespace = "com.anotn.antstock.news"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}