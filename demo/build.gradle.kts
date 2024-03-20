import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone


plugins {
    id(libs.plugins.kotlin.multiplatform.get().pluginId)  // Adds support for Kotlin/JS

    alias(libs.plugins.grgit)
    alias(libs.plugins.buildconfig)  // Adds support for BuildConfig.kt object generation
}


val projectGroup = "dev.tonycode.kotlin-wrappers"
val projectArtifact = "kotlin-recharts-demo"
val projectPackage = "$projectGroup.$projectArtifact".replace("-", "_")
val projectName = projectArtifact
val projectVersion = "0.1.0-SNAPSHOT"
val buildNumber = 0
val isProduction: Boolean = (properties["prod"] == "true")  // turn off debugging stuff (sourcemaps/logging/..) for prod

group = projectGroup
version = projectVersion

buildConfig {
    packageName(projectPackage)

    // build info
    buildConfigField("APP_NAME", projectName)
    buildConfigField("BUILD_VERSION", projectVersion)
    buildConfigField("BUILD_NUMBER", buildNumber)
    buildConfigField("GIT_BRANCH_NAME", grgit.branch.current().name)
    buildConfigField("GIT_COMMIT_ID", grgit.head().abbreviatedId)
    buildConfigField("BUILD_TIME",
        SimpleDateFormat("yyyy.MM.dd EEE 'at' HH:mm:ss.SSS z").apply {
            timeZone = TimeZone.getTimeZone("GMT")
        }.format(Date(System.currentTimeMillis()))
    )
    buildConfigField("BUILD_TIME_MILLIS", System.currentTimeMillis())

    buildConfigField("IS_PRODUCTION", isProduction)
}

kotlin {
    js {
        moduleName = projectArtifact
        browser {
            commonWebpackConfig(Action {
                outputFileName = "$projectArtifact.js"
                sourceMaps = !isProduction
                cssSupport { enabled = true }
            })
        }

        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                //// Core
                implementation(platform(libs.kotlin.bom.get()))  // Align versions of all Kotlin components
                implementation(libs.kotlin.stdlib)  // Use the Kotlin standard library

                //// UI
                implementation(platform(libs.kotlin.wrappers.bom.get()))
                implementation(libs.kotlinw.react)
                implementation(libs.kotlinw.react.dom)
                implementation(libs.kotlinw.emotion)
                implementation("dev.tonycode.kotlin-wrappers:kotlin-antd:0.1.0-SNAPSHOT") {
                    isChanging = true
                }

                // kotlin-recharts
                implementation(projects.library)
            }
        }
    }
}


tasks.withType<KotlinJsCompile>().configureEach {
    kotlinOptions {
        moduleName = projectArtifact
        moduleKind = moduleDefinition
        sourceMap = !isProduction
    }
}

val moduleDefinition = if (findProperty("modular") == "true") "commonjs" else "umd"
