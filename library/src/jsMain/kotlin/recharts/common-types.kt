package recharts


@OptIn(ExperimentalJsExport::class)
@JsExport
data class Margin(
    val top: Int,
    val right: Int,
    val left: Int,
    val bottom: Int
)

@OptIn(ExperimentalJsExport::class)
@JsExport
data class ActiveDot(
    val r: Int
)
