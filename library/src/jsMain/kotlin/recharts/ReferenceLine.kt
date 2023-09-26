@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props
import web.cssom.Color


@JsName("ReferenceLine")
external val ReferenceLine: ComponentClass<ReferenceLineProps>

external interface ReferenceLineProps : Props {

    /**
     * The id of x-axis which is corresponding to the data
     */
    var xAxisId: String

    /**
     * The id of y-axis which is corresponding to the data
     */
    var yAxisId: String

    var x: String

    var y: String

    var stroke: Color

    var label: String

}
