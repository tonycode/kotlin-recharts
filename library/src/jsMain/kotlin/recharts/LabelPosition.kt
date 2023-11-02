package recharts


@Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)
// language=JavaScript
@JsName("""(/*union*/{
    top: 'top', left: 'left', right: 'right', bottom: 'bottom',
    inside: 'inside', outside: 'outside',
    insideLeft: 'insideLeft', insideRight: 'insideRight', insideTop: 'insideTop', insideBottom: 'insideBottom',
    insideTopLeft: 'insideTopLeft', insideBottomLeft: 'insideBottomLeft', insideTopRight: 'insideTopRight', insideBottomRight: 'insideBottomRight',
    end: 'end', center: 'center'
}/*union*/)""")
/**
 * see: https://recharts.org/en-US/api/Label
 */
sealed external interface LabelPosition {

    companion object {
        val top: LabelPosition
        val left: LabelPosition
        val right: LabelPosition
        val bottom: LabelPosition
        val inside: LabelPosition
        val outside: LabelPosition
        val insideLeft: LabelPosition
        val insideRight: LabelPosition
        val insideTop: LabelPosition
        val insideBottom: LabelPosition
        val insideTopLeft: LabelPosition
        val insideBottomLeft: LabelPosition
        val insideTopRight: LabelPosition
        val insideBottomRight: LabelPosition
        val insideStart: LabelPosition
        val insideEnd: LabelPosition
        val end: LabelPosition
        val center: LabelPosition
    }

}
