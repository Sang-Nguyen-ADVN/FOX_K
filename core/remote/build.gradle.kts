import dependencies.Dependencies
import extensions.*
import extensions.implementation
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("commons.android-library")
//    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    buildTypes.forEach {
        try {
            it.buildConfigStringField("FOX_API_BASE_URL", BuildApiConfig.FOX_API_BASE_URL)
            it.buildConfigStringField("FOX_API_BASE_API", BuildApiConfig.FOX_API_BASE_API)
            it.buildConfigStringField("FOX_API_BASE_POST", BuildApiConfig.FOX_API_BASE_POST)
            it.buildConfigStringField("FOX_SHARE_PREFERENCE_NAME", BuildApiConfig.FOX_SHARE_PREFERENCE_NAME)
        } catch (ignored: Exception) {
            throw InvalidUserDataException(
                "You don't define"
            )
        }
    }
}

dependencies {

    //MODULE
//    implementation(project(BuildModules.CORES.DATA))

    implementation(Dependencies.CORE_KTX)

    //LIFECYCLE
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)

    //NETWORK
    implementation(Dependencies.OKHTTP3)
    implementation(Dependencies.OKHTTP3_LOGGING)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_RX_ADAPTER)
    implementation(Dependencies.RETROFIT_CONVERTER)
    implementation(Dependencies.NETWORK_RESPONSE)

    //DATA
    implementation(Dependencies.MOSHI)
    implementation(Dependencies.MOSHI_COGEN)
    implementation(Dependencies.MOSHI_KTX)
    implementation(Dependencies.MOSHI_ADAPTER)
    implementation(Dependencies.MOSHI_CONVERTER)

    addTestsDependencies()
}


