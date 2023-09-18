@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props
import web.cssom.Color


/**
 * https://recharts.org/en-US/api/ReferenceArea
 */
@JsName("ReferenceArea")
external val ReferenceArea : ComponentClass<ReferenceAreaProps>

external interface ReferenceAreaProps : Props {

    /**
     * The id of x-axis which is corresponding to the data
     *
     * default: 0
     */
    var xAxisId: String

    /**
     * The id of y-axis which is corresponding to the data
     *
     * default: 0
     */
    var yAxisId: String

    /**
     * A boundary value of the area.
     * If the specified x-axis is a number axis, the type of x must be Number.
     * If the specified x-axis is a category axis, the value of x must be one of the categories.
     * If one of x1 or x2 is invalidate, the area will cover along x-axis.
     */
    var x1: String

    /**
     * A boundary value of the area.
     * If the specified x-axis is a number axis, the type of x must be Number.
     * If the specified x-axis is a category axis, the value of x must be one of the categories.
     * If one of x1 or x2 is invalidate, the area will cover along x-axis.
     */
    var x2: String

    /**
     * A boundary value of the area.
     * If the specified y-axis is a number axis, the type of y must be Number.
     * If the specified y-axis is a category axis, the value of y must be one of the categories.
     * If one of y1 or y2 is invalidate, the area will cover along y-axis.
     */
    var y1: String

    /**
     * A boundary value of the area.
     * If the specified y-axis is a number axis, the type of y must be Number.
     * If the specified y-axis is a category axis, the value of y must be one of the categories.
     * If one of y1 or y2 is invalidate, the area will cover along y-axis.
     */
    var y2: String

    var stroke: Color

    var fill: Color

    var label: String

}
