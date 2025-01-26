plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

android {
    namespace = "com.doxart.easypops"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

configure<PublishingExtension> {
    publications.create<MavenPublication>("EasyPops") {
        groupId = "com.github.doxart"
        artifactId = "EasyPops"
        version = "1.0.0"
    }
    repositories {
        mavenLocal()
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
