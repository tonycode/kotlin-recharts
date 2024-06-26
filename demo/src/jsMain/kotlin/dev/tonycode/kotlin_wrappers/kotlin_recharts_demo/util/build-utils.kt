package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.util

import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.BuildConfig


fun getBuildInfo(): String {
    return "${BuildConfig.APP_NAME} v${BuildConfig.BUILD_VERSION}" +
        " (" +
        "git: ${BuildConfig.GIT_BRANCH_NAME}@${BuildConfig.GIT_COMMIT_ID}" +
        ", built on ${BuildConfig.BUILD_TIME}" +
        ")"
}
