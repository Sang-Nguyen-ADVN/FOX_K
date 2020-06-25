import dependencies.Dependencies
import extensions.*
import extensions.implementation
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("commons.android-library")
    id(BuildPlugins.KOTLIN_KAPT)
}
android {
    buildTypes.forEach {
        try {
            it.buildConfigStringField("FOX_DATABASE_NAME", BuildApiConfig.FOX_DATABASE_NAME)
            it.buildConfigIntField("FOX_DATABASE_VERSION", BuildApiConfig.FOX_DATABASE_VERSION)
            it.buildConfigBooleanField(
                "FOX_DATABASE_EXPORT_SCHEMA",
                BuildApiConfig.FOX_DATABASE_EXPORT_SCHEMA
            )
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
    implementation(project(BuildModules.COMMONS.BASE))

    //DATA

    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    kapt(Dependencies.ROOM_COMPILER)

    //FIREBASE

    addTestsDependencies()
}