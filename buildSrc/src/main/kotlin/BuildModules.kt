/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"

    object FEATURES {
        const val HOME = ":features:ui_home"
        const val TAGS = ":features:ui_tags"
        const val ORGANIZATIONS = ":features:ui_organizations"
        const val EVENTS = ":features:ui_events"
        const val SETTINGS = ":features:ui_settings"
        const val MORE = ":features:ui_more"
        const val LOGIN = ":features:ui_login"
    }

    object CORES {
        const val REMOTE = ":core:remote"
        const val DATA = ":core:data"
        const val CACHE = ":core:cache"
        const val DOMAIN = ":core:domain"
        const val LOCAL = ":core:local"
    }

    object COMMONS {
        const val BASE = ":commons:base"
        const val UI = ":commons:ui"
        const val UTIL = ":commons:utils"
        const val NAVIGATION = ":commons:navigation"
    }

    object LIBRARY {
        const val TEST_UTILS = ":libraries:test_utils"
    }
}
