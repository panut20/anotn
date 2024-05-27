
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.apolloGraphql)
}

android {
    namespace = "com.antstock.android.data"
    compileSdk = 34

    defaultConfig {

        minSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.apollo.runtime)
    implementation(libs.kakao.user)
    implementation(libs.kakao.cert)

    implementation(project(":domain"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
apollo {
    service("service") {
        packageName.set("com.antstock.android.data.out.graphql")
    }
}
