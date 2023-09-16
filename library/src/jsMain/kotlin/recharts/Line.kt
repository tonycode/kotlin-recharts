@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props
import web.cssom.Color


/**
 * https://recharts.org/en-US/api/Line
 */
@JsName("Line")
external val Line : ComponentClass<LineProps>

external interface LineProps : Props {

    /**
     * The interpolation type of line.
     * And customized interpolation function can be set to type.
     * It's the same as type in Area.
     *
     * Examples:
     * - https://github.com/d3/d3-shape#curves
     * - https://recharts.org/en-US/examples/CardinalAreaChart
     *
     * default: [LineType.linear]
     */
    var type: LineType

    /**
     * The key or getter of a group of data which should be unique in a LineChart
     */
    var dataKey: String

    /**
     * The id of x-axis which is corresponding to the data
     *
     * default: "0"
     */
    var xAxisId: String

    /**
     * The id of y-axis which is corresponding to the data
     *
     * default: "0"
     */
    var yAxisId: String

    /** e.g. Color("#8884d8") */
    var stroke: Color

    var strokeWidth: Int

    /** e.g. "3 4 5 2" or "5 5" */
    var strokeDasharray: String

    var activeDot: ActiveDot

}
