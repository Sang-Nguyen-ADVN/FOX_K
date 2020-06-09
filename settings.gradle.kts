include(
    ":app",
    ":commons:base",
    ":commons:ui",
    ":commons:utils",
    ":commons:navigation",
    ":features:ui_events",
    ":features:ui_organizations",
    ":features:ui_tags",
    ":features:ui_home",
    ":features:ui_more",
    ":features:ui_settings",
    ":features:ui_login",
    ":core:remote",
    ":core:cache",
    ":core:domain",
    ":core:local",
    ":core:data"
)

rootProject.name = "FOX"
rootProject.buildFileName = "build.gradle.kts"