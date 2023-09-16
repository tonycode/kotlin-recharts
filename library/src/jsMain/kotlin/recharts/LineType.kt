@file:Suppress(
    "NAME_CONTAINS_ILLEGAL_CHARS",
    "NESTED_CLASS_IN_EXTERNAL_INTERFACE",
)

package recharts


// language=JavaScript
@JsName("""(/*union*/{
    basis: 'basis', basisClosed: 'basisClosed', basisOpen: 'basisOpen',
    bumpX: 'bumpX', bumpY: 'bumpY', bump: 'bump',
    linear: 'linear', linearClosed: 'linearClosed',
    natural: 'natural',
    monotoneX: 'monotoneX', monotoneY: 'monotoneY', monotone: 'monotone',
    step: 'step', stepBefore: 'stepBefore', stepAfter: 'stepAfter'
}/*union*/)""")
sealed external interface LineType {

    companion object {
        val basis: LineType
        val basisClosed: LineType
        val basisOpen: LineType
        val bumpX: LineType
        val bumpY: LineType
        val bump: LineType
        val linear: LineType
        val linearClosed: LineType
        val natural: LineType
        val monotoneX: LineType
        val monotoneY: LineType
        val monotone: LineType
        val step: LineType
        val stepBefore: LineType
        val stepAfter: LineType
    }

}
