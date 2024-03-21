import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile


plugins {
    id(libs.plugins.kotlin.multiplatform.get().pluginId)  // Adds support for Kotlin/JS

    `maven-publish`
    signing
}


val projectGroup = "dev.tonycode.kotlin-wrappers"
val projectArtifact = "kotlin-recharts"
val projectVersion = libs.versions.rechartsWrapper.get()
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
                //// Core
                api(project.dependencies.platform(libs.kotlin.bom.get()))  // Align versions of all Kotlin components
                api(libs.kotlin.stdlib)  // Use the Kotlin standard library

                //// UI
                api(project.dependencies.platform(libs.kotlin.wrappers.bom.get()))
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
        name = rootProject.name
        description = "Kotlin wrapper for ReCharts (React charting library, https://recharts.org/)"
        url = "https://github.com/tonycode/kotlin-recharts"

        licenses {
            license {
                name = "MIT License"
                url = "https://github.com/tonycode/kotlin-recharts/blob/main/LICENSE"
            }
        }

        developers {
            developer {
                id = "tonycode"
                name = "Anton Vasilev"
                email = "opensource@tonycode.dev"
                organization = "tonycode"
                organizationUrl = "https://tonycode.dev/"
            }
        }

        scm {
            connection = "scm:git:git://github.com/tonycode/kotlin-recharts.git"
            developerConnection = "scm:git:git@github.com:tonycode/kotlin-recharts.git"
            url = "https://github.com/tonycode/kotlin-recharts"
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
