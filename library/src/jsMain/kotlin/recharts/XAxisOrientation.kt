@file:Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)

package recharts


// language=JavaScript
@JsName("""(/*union*/{bottom: 'bottom', top: 'top'}/*union*/)""")
sealed external interface XAxisOrientation {

    companion object {
        val bottom: XAxisOrientation
        val top: XAxisOrientation
    }

}
