@file:Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)

package recharts


// language=JavaScript
@JsName("""(/*union*/{left: 'left', right: 'right'}/*union*/)""")
sealed external interface YAxisOrientation {

    companion object {
        val left: YAxisOrientation
        val right: YAxisOrientation
    }

}
