rootProject.name = "kotlin-recharts"


pluginManagement {
    repositories {
        gradlePluginPortal()  // https://plugins.gradle.org
        mavenCentral()  // https://repo.maven.apache.org/maven2/
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.PREFER_PROJECT  // kotlin-js adds "Node Distributions" repo

    repositories {
        // https://mvnrepository.com/ - find repository & artifact version for a given package

        mavenCentral()  // https://repo.maven.apache.org/maven2/
        //maven("https://jitpack.io")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")  // for kotlin-antd

        //mavenLocal()  // ~/.m2/repository
    }
}

// https://docs.gradle.org/current/userguide/declaring_dependencies.html#sec:type-safe-project-accessors
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


include(
    "library",
    "demo"
)
