import extensions.applyDefault
import com.vanniktech.android.junit.jacoco.JunitJacocoExtension

plugins.apply(BuildPlugins.GIT_HOOKS)
plugins.apply(BuildPlugins.UPDATE_DEPENDENCIES)

allprojects {
    repositories.applyDefault()

    plugins.apply(BuildPlugins.DETEKT)
    plugins.apply(BuildPlugins.DOKKA)
    plugins.apply(BuildPlugins.KTLINT)
    plugins.apply(BuildPlugins.SPOTLESS)
}
