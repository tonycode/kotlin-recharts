@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


@JsName("LineChart")
external val LineChart : ComponentClass<LineChartProps>

external interface LineChartProps : Props {

    var width: Int

    var height: Int

    var margin: Margin

    var data: Array<out Any>

}
