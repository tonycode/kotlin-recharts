package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.model


@OptIn(ExperimentalJsExport::class)
@JsExport
data class Measurement(

    val day: Int,

    val value: Double

)
