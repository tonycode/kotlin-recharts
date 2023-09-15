@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


@JsName("ReferenceLine")
external val ReferenceLine : ComponentClass<ReferenceLineProps>

external interface ReferenceLineProps : Props {

    var x : String

    var stroke: String

    var label: String

}
