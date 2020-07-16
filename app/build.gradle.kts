import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.implementation
import extensions.kapt
import utils.SIGNING_DEBUG_PROPERTIES_FILE_NAME
import utils.manageSigningConfig

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.CRASHLYTICS)
    id(BuildPlugins.PERFORMANCE)
    id(BuildPlugins.GOOGLE_SERVICES)
    kotlin(BuildPlugins.KOTLIN_PRE_ANDROID)
    kotlin(BuildPlugins.KOTLIN_PRE_ANDROID_EXTENSIONS)
    kotlin(BuildPlugins.KOTLIN_PRE_KAPT)
    id(BuildPlugins.KOTLIN_ALLOPEN)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
    id(BuildPlugins.JACOCO)
    id(BuildPlugins.GRAPH_GENERATOR)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID

        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
//        testInstrumentationRunnerArguments = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER_ARGUMENTS

        resConfigs(AndroidSdk.locales)
    }

    signingConfigs {
        getByName(BuildTypeCustom.DEBUG) {
            manageSigningConfig(this, SIGNING_DEBUG_PROPERTIES_FILE_NAME)
            firebaseCrashlytics {
                nativeSymbolUploadEnabled = true
            }
        }
        create(BuildTypeCustom.RELEASE) {
//            manageSigningConfig(this, SIGNING_RELEASE_PROPERTIES_FILE_NAME)
            firebaseCrashlytics {
                nativeSymbolUploadEnabled = true
            }
        }
    }

    buildTypes {
        Debug.create(this, project, signingConfigs)
        Release.create(this, project, signingConfigs)
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)

    productFlavors {
        ProductFlavorDevelop.appCreate(this)
        ProductFlavorProduction.appCreate(this)
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
            java.srcDirs("build/generated/source/navigation-args")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
            java.srcDirs("build/generated/source/navigation-args")
        }

        getByName("androidTest").java.srcDirs("src/androidTest/kotlin/")
    }

    dynamicFeatures = mutableSetOf(
        BuildModules.FEATURES.HOME,
        BuildModules.FEATURES.TAGS,
        BuildModules.FEATURES.EVENTS,
        BuildModules.FEATURES.ORGANIZATIONS,
        BuildModules.FEATURES.MORE,
        BuildModules.FEATURES.SETTINGS,
        BuildModules.FEATURES.LOGIN
    )

    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }

    packagingOptions.exclude("META-INF/DEPENDENCIES")
    packagingOptions.exclude("META-INF/LICENSE")
    packagingOptions.exclude("META-INF/LICENSE.txt")
    packagingOptions.exclude("META-INF/license.txt")
    packagingOptions.exclude("META-INF/NOTICE'")
    packagingOptions.exclude("META-INF/NOTICE.txt")
    packagingOptions.exclude("META-INF/notice.txt")
    packagingOptions.exclude("META-INF/ASL2.0")
    packagingOptions.exclude("META-INF/*.kotlin_module")

}


androidExtensions {
    isExperimental = true
}


dependencies {
    //CORE
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.MULTIDEX)

    //LIFECYCLE
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.LIFECYCLE_LIVEDATA)

    //LAYOUT
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.LEGACY)
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.RECYCLE_VIEW)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.VIEWPAGER2)
    implementation(Dependencies.COIL)
    implementation(Dependencies.PRO_PROGRESS_VIEWS)
    implementation(Dependencies.PAGING)
    implementation(Dependencies.PROGRESS_BUTTON)
    implementation(Dependencies.PROGRESS_BAR)
    implementation(Dependencies.SDP)
    implementation(Dependencies.SSP)


    //NAVIGATION
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_DYNAMIC_FEATURE)

    //NETWORK
    implementation(Dependencies.OKHTTP3_LOGGING)
    implementation(Dependencies.RETROFIT)

    //FIREBASE
    implementation(Dependencies.FIREBASE_AUTH)
    implementation(Dependencies.FIREBASE_CORE)
    implementation(Dependencies.FIREBASE_ANALYTICS)
    implementation(Dependencies.FIREBASE_FIRE_STORE)
    implementation(Dependencies.FIREBASE_FIRE_STORAGE)
    implementation(Dependencies.FIREBASE_PERFORMANCE)
    implementation(Dependencies.FIREBASE_DATABASE)
    implementation(Dependencies.CRASHLYTICS)
    implementation(Dependencies.GOOGLE_AUTH_LOGIN)
    implementation(Dependencies.GOOGLE_AUTH_PHONE)

    //DI
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_VIEW_MODEL)
    implementation(Dependencies.KOIN_EXT)

    //COROUTINE
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.COROUTINES_MANAGER)

    //DATA
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    kapt(Dependencies.ROOM_COMPILER)

    //IMAGE
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)

    //LOG
    implementation(Dependencies.TIMBER)

    implementation(project(BuildModules.COMMONS.BASE))
    implementation(project(BuildModules.COMMONS.UI))
    implementation(project(BuildModules.COMMONS.UTIL))
    implementation(project(BuildModules.COMMONS.NAVIGATION))
    implementation(project(BuildModules.CORES.DOMAIN))
    implementation(project(BuildModules.CORES.CACHE))
    implementation(project(BuildModules.CORES.LOCAL))
    implementation(project(BuildModules.CORES.REMOTE))
    implementation(project(BuildModules.CORES.DATA))

    kapt(AnnotationProcessorsDependencies.DATABINDING)
}