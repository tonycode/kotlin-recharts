@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


/**
 * https://recharts.org/en-US/api/YAxis
 */
@JsName("YAxis")
external val YAxis: ComponentClass<YAxisProps>

external interface YAxisProps : Props {

    /**
     * If set true, the axis do not display in the chart
     *
     * default: false
     */
    var hide: Boolean

    /**
     * The key of data displayed in the axis
     */
    var dataKey: String

    /**
     * The unique id of y-axis
     *
     * default: "0"
     */
    var yAxisId: String

    /**
     * The orientation of axis
     *
     * default: [YAxisOrientation.left]
     */
    var orientation: YAxisOrientation

    /**
     * If set a string or a number, default label will be drawn, and the option is content.
     * If set a React element, the option is the custom react element of drawing label.
     * If an object, the option is the props of a new Label instance.
     *
     * see: [YAxisProps.setLabel]
     */
    var label: dynamic  // String | Number | ReactElement | Object

}
