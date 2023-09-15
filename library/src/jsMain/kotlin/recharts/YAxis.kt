@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


@JsName("YAxis")
external val YAxis : ComponentClass<YAxisProps>


external interface YAxisProps : Props {

    var yAxisId: String

    /** e.g. "right" */
    var orientation: String?

}
