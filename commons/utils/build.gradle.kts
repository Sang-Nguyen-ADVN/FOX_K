import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation
import extensions.kapt

plugins {
    id("commons.android-library")
    id(BuildPlugins.KOTLIN_KAPT)
}


dependencies {

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

    //IMAGE
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)

    //DATABASE
    implementation(Dependencies.MOSHI)
    implementation(Dependencies.MOSHI_KTX)

    kapt(Dependencies.MOSHI_COGEN)
    kapt(AnnotationProcessorsDependencies.DATABINDING)
}