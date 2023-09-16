@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props
import web.cssom.Color


/**
 * https://recharts.org/en-US/api/CartesianGrid
 */
@JsName("CartesianGrid")
external val CartesianGrid : ComponentClass<CartesianGridProps>

external interface CartesianGridProps : Props {

    /**
     * If set false, no horizontal grid lines will be drawn
     *
     * default: true
     */
    var horizontal: Boolean

    /**
     * If set false, no vertical grid lines will be drawn
     *
     * default: true
     */
    var vertical: Boolean

    /**
     * The background color used to fill the space between grid lines
     *
     * e.g.: Color("red"), Color("#ccc")
     */
    var fill: Color

    /**
     * The opacity of the background used to fill the space between grid lines
     */
    var fillOpacity: Double

    /**
     * The pattern of dashes and gaps used to paint the lines of the grid
     *
     * e.g.: "4" (dash width and same gap width)
     * e.g.: "4 1" (dash w4, gap w1)
     * e.g.: "4 1 2" (dash w4, gap w1, dash w2, gap w4, dash w1, gap w2)
     */
    var strokeDasharray: String

    /**
     * The stroke color
     *
     * e.g.: Color("red"), Color("#ccc")
     */
    var stroke: Color

}
