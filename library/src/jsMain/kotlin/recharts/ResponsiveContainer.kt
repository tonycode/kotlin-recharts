@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props
import web.cssom.Length


@JsName("ResponsiveContainer")
external val ResponsiveContainer : ComponentClass<ResponsiveContainerProps>

external interface ResponsiveContainerProps : Props {

    var width: Length

    var height: Int

}
