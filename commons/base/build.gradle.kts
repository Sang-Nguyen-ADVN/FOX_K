import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation
import extensions.kapt

plugins {
    id("commons.android-library")
    id(BuildPlugins.KOTLIN_KAPT)
}

junitJacoco {
    excludes = listOf("**/extensions/NavigationExtensions*.*")
}

dependencies {
    //MODULE
    implementation(project(BuildModules.COMMONS.UI))

    //SUPPORT
    implementation(Dependencies.LEAK_CANARY)
    implementation(Dependencies.MULTIDEX)
    //CORE
    implementation(Dependencies.CORE_KTX)

    //LIFECYCLE
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.LIFECYCLE_LIVEDATA)
    implementation(Dependencies.LIFECYCLE_RUNTIME)

    //LAYOUT
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.RECYCLE_VIEW)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.VIEWPAGER2)
    implementation(Dependencies.COIL)
    implementation(Dependencies.PRO_PROGRESS_VIEWS)
    implementation(Dependencies.SWIPE_REFRESH_LAYOUT)
    implementation(Dependencies.MATERIAL_DIALOG)


    //PAGER
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.PAGING)

    //NETWORK
    implementation(Dependencies.OKHTTP3_LOGGING)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.NETWORK_RESPONSE)

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

    //FACEBOOK
    implementation(Dependencies.FACEBOOK_OKHTTP)
    implementation(Dependencies.FACEBOOK_STETHO)
    implementation(Dependencies.FACEBOOK_STETHO_JS)

    //FIREBASE
    implementation(Dependencies.FIREBASE_AUTH)
//    implementation(Dependencies.FIREBASE_CORE)
    implementation(Dependencies.FIREBASE_CONFIG)
    implementation(Dependencies.FIREBASE_ANALYTICS)
    implementation(Dependencies.FIREBASE_FIRESTORE)
    implementation(Dependencies.GOOGLE_AUTH_LOGIN)
    implementation(Dependencies.GOOGLE_AUTH_PHONE)

    //LOG
    implementation(Dependencies.TIMBER)

    //PROJECT
    implementation(project(BuildModules.COMMONS.UI))
    implementation(project(BuildModules.COMMONS.UTIL))

    kapt(AnnotationProcessorsDependencies.DATABINDING)
}