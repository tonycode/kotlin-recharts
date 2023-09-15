@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


@JsName("Line")
external val Line : ComponentClass<LineProps>

external interface LineProps : Props {

    var yAxisId: String?

    /** e.g. "monotone" */
    var type: String

    var dataKey: String

    /** e.g. "#8884d8" */
    var stroke: String

    var strokeWidth: Int

    /** e.g. "3 4 5 2" or "5 5" */
    var strokeDasharray: String

    var activeDot: ActiveDot

}
