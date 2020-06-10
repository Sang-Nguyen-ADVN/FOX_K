import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation
import extensions.kapt

plugins {
    id("commons.android-library")
}

junitJacoco {
    excludes = listOf("**/extensions/NavigationExtensions*.*")
}


dependencies {
    //CORE

    //MODULES
    //implementation(project(BuildModules.COMMONS.UI))
    //implementation(project(BuildModules.APP))
    //implementation(project(BuildModules.FEATURES.EVENTS))
    //implementation(project(BuildModules.FEATURES.HOME))
    //implementation(project(BuildModules.FEATURES.LOGIN))
    //implementation(project(BuildModules.FEATURES.MORE))
    //implementation(project(BuildModules.FEATURES.ORGANIZATIONS))
    //implementation(project(BuildModules.FEATURES.SETTINGS))
    //implementation(project(BuildModules.FEATURES.TAGS))

    //NAVIGATION
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_DYNAMIC_FEATURE)
}