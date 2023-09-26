@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


/**
 * https://recharts.org/en-US/api/XAxis
 */
@JsName("XAxis")
external val XAxis: ComponentClass<XAxisProps>

external interface XAxisProps : Props {

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
     * The unique id of x-axis
     *
     * default: "0"
     */
    var xAxisId: String

    /**
     * The orientation of axis
     *
     * default: [XAxisOrientation.bottom]
     */
    var orientation: XAxisOrientation

    /**
     * Allow the axis has duplicated categorys or not when the type of axis is "category"
     *
     * default: true
     */
    var allowDuplicatedCategory: Boolean

}
