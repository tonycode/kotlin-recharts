@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


@JsName("CartesianGrid")
external val CartesianGrid : ComponentClass<CartesianGridProps>

external interface CartesianGridProps : Props {

    /** e.g. "3 3" */
    var strokeDasharray: String

}
