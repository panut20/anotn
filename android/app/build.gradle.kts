import com.android.build.gradle.tasks.detectAnnotationProcessors

plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.anotn.antstock.android"
    compileSdk = 34


    viewBinding {
        enable = true
    }
    dataBinding {
        enable = true
    }
    defaultConfig {
        applicationId = "com.anotn.antstock.android"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    implementation(libs.mpandroidchart)
    implementation(project(":domain"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
