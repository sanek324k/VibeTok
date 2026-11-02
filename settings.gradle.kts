pluginManagement { repositories { google(); mavenCentral(); gradlePluginPortal() } }
dependencyResolutionManagement {
    repositories { google(); mavenCentral(); maven("https://api.xposed.info/") }
}
rootProject.name = "VibeTok"
include(":app")
