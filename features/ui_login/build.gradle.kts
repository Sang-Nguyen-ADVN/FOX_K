import dependencies.Dependencies

plugins {
    id("commons.android-dynamic-feature")
}

junitJacoco {
    excludes = listOf("**/extensions/NavigationExtensions*.*")
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    //FIREBASE
//    implementation(Dependencies.FIREBASE_AUTH)
//    implementation(Dependencies.FIREBASE_CORE)
//    implementation(Dependencies.FIREBASE_ANALYTICS)
//    implementation(Dependencies.FIREBASE_FIRESTORE)
//    implementation(Dependencies.FIREBASE_CRASHLYTICS)
//    implementation(Dependencies.FIREBASE_MESSAGING)
//    implementation(Dependencies.GOOGLE_AUTH_LOGIN)
//    implementation(Dependencies.GOOGLE_AUTH_PHONE)
}