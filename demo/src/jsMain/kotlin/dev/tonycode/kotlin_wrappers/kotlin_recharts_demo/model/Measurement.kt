package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.model


@OptIn(ExperimentalJsExport::class)
@JsExport
data class Measurement(

    /**
     * format: "dd-MMM"
     *
     * e.g.: "31-dec"
     */
    val date: String,

    val steps: Int,

    val avgBpm: Double

)
