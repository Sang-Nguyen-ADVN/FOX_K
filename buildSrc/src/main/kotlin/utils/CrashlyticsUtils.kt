package utils

import com.android.builder.signing.DefaultSigningConfig
import org.gradle.api.Project

const val SIGNING_DEBUG_PROPERTIES_FILE_NAME = "resources/properties/config-file.properties"
const val SIGNING_RELEASE_PROPERTIES_FILE_NAME = "resources/properties/config-file.properties"
private const val SIGNING_KEY_STOREFILE = "storeFile"
private const val SIGNING_KEY_STOREPASS = "storePassword"
private const val SIGNING_KEY_ALIAS = "keyAlias"
private const val SIGNING_KEY_PASSWORD = "keyPassword"

fun Project.manageSigningConfig(defaultSigningConfig: DefaultSigningConfig, fileName: String) {
    defaultSigningConfig.apply {
        keyAlias = getPropertyName(fileName, SIGNING_KEY_ALIAS, this@manageSigningConfig)
        keyPassword = getPropertyName(fileName, SIGNING_KEY_PASSWORD, this@manageSigningConfig)
        storeFile = file("../${getPropertyName(fileName, SIGNING_KEY_STOREFILE, this@manageSigningConfig)}")
        storePassword = getPropertyName(fileName, SIGNING_KEY_STOREPASS, this@manageSigningConfig)
    }
}
