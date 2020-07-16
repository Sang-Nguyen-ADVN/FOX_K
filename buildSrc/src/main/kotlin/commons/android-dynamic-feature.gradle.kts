package commons

import BuildAndroidConfig
import BuildProductDimensions
import ProductFlavorDevelop
import ProductFlavorProduction
import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.addTestsDependencies
import extensions.implementation
import extensions.testImplementation
//import extensions.kapt

plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-android-extensions")
//    id("kotlin-kapt")
    id("kotlin-allopen")
    id("androidx.navigation.safeargs.kotlin")
    id("com.vanniktech.android.junit.jacoco")
    id("com.vanniktech.dependency.graph.generator")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures.viewBinding = true
//    buildFeatures.dataBinding = true
//    buildFeatures{
//        viewBinding = true
//        dataBinding = true
//    }
    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)

    productFlavors {
        ProductFlavorDevelop.libraryCreate(this)
        ProductFlavorProduction.libraryCreate(this)
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
        isAbortOnError = false
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

junitJacoco {
    includeNoLocationClasses = true
}

dependencies {

    //MODULE
    implementation(project(BuildModules.APP))
    implementation(project(BuildModules.CORES.REMOTE))
    implementation(project(BuildModules.CORES.DOMAIN))
    implementation(project(BuildModules.COMMONS.BASE))
    implementation(project(BuildModules.COMMONS.UI))
    implementation(project(BuildModules.COMMONS.UTIL))
    implementation(project(BuildModules.COMMONS.NAVIGATION))

    //LAYOUT
    implementation(Dependencies.LEGACY)
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.COIL)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.SDP)
    implementation(Dependencies.SSP)


    //NAVIGATION
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)

    //LIFECYCLE
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)

    //COROUTINE
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.COROUTINES_MANAGER)
    implementation(Dependencies.NAVIGATION_FRAGMENT)

    //DI
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_VIEW_MODEL)
    implementation(Dependencies.KOIN_EXT)

    //DEBUG
    implementation(Dependencies.TIMBER)

    addTestsDependencies()
}
