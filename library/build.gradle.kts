import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile


plugins {
    id(libs.plugins.kotlin.multiplatform.get().pluginId)  // Adds support for Kotlin/JS

    `maven-publish`
    signing
}


val projectGroup = "dev.tonycode.kotlin-wrappers"
val projectArtifact = "kotlin-recharts"
val projectPackage = "$projectGroup.$projectArtifact"
val projectVersion = "0.1.0-SNAPSHOT"
val buildNumber = "0"
val isRelease = false  // release library build (for Maven Central publication)

group = projectGroup
version = projectVersion

kotlin {
    js {
        moduleName = projectArtifact  // used for: package.json
        browser()

        compilations {
            val main by getting
            main.apply {
                kotlinOptions {
                    // used for: klib/manifest/unique_name
                    freeCompilerArgs += "-Xir-module-name=$projectGroup:$projectArtifact"
                }
            }
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                api(libs.kotlinw.react)
                api(libs.kotlinw.react.dom)

                implementation(npm("recharts", libs.versions.recharts.get()))
            }
        }
    }
}

tasks.withType<KotlinJsCompile>().configureEach {
    kotlinOptions {
        moduleName = projectArtifact
        moduleKind = moduleDefinition
        sourceMap = false
    }
}

val moduleDefinition = if (findProperty("modular") == "true") "commonjs" else "umd"


//region publication
val ossrhUsername: String? by project
val ossrhPassword: String? by project

tasks.withType<Sign>().configureEach {
    onlyIf { isRelease }
}

publishing {
    repositories {
        maven {
            val snapshotRepositoryUrl: String by project
            val releaseRepositoryUrl: String by project
            val repositoryUrl = if (isRelease) releaseRepositoryUrl else snapshotRepositoryUrl

            url = uri(repositoryUrl)

            credentials {
                username = ossrhUsername.orEmpty()
                password = ossrhPassword.orEmpty()
            }
        }
        mavenLocal()  // for debugging purposes
    }

    publications {
        withType<MavenPublication>().configureEach {
            groupId = projectGroup
            artifactId = projectArtifact
            version = projectVersion

            configurePom()
        }
    }
}


fun MavenPublication.configurePom() {
    pom {
        name.set(rootProject.name)
        description.set("Kotlin wrapper for ReCharts (React charting library, https://recharts.org/)")
        url.set("https://github.com/tonycode/kotlin-recharts")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://github.com/tonycode/kotlin-recharts/blob/main/LICENSE")
            }
        }

        developers {
            developer {
                id.set("tonycode")
                name.set("Anton Vasilev")
                email.set("opensource@tonycode.dev")
                organization.set("tonycode")
                organizationUrl.set("https://tonycode.dev/")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/tonycode/kotlin-recharts.git")
            developerConnection.set("scm:git:git@github.com:tonycode/kotlin-recharts.git")
            url.set("https://github.com/tonycode/kotlin-recharts")
        }
    }
}

signing {
    setRequired({
        gradle.taskGraph.hasTask("publish")
    })

    sign(publishing.publications)
}
//endregion
