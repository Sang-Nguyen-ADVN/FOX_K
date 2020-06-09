import dependencies.Dependencies
plugins {
    id("commons.android-library")
}
dependencies {
    //MODULES
    implementation(project(BuildModules.COMMONS.BASE))
    implementation(project(BuildModules.CORES.DATA))
    implementation(project(BuildModules.CORES.CACHE))
    implementation(project(BuildModules.CORES.LOCAL))
    implementation(project(BuildModules.CORES.REMOTE))
    //FIREBASE
    implementation(Dependencies.FIREBASE_AUTH)
//    implementation(Dependencies.FIREBASE_CORE)
    implementation(Dependencies.FIREBASE_ANALYTICS)
    implementation(Dependencies.FIREBASE_FIRESTORE)
    implementation(Dependencies.GOOGLE_AUTH_LOGIN)
    implementation(Dependencies.GOOGLE_AUTH_PHONE)
    //NETWORK
    implementation(Dependencies.NETWORK_RESPONSE)
}
