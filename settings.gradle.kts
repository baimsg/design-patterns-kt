dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

pluginManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "design-patterns"
include("calculator")
include("strategy-cashier")
include("decorator-dressUp")
include("proxy-pursue")
