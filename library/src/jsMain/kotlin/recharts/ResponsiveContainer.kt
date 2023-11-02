@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.PropsWithChildren
import react.PropsWithClassName
import web.cssom.Length


@JsName("ResponsiveContainer")
external val ResponsiveContainer: ComponentClass<ResponsiveContainerProps>

external interface ResponsiveContainerProps : PropsWithClassName, PropsWithChildren {

    var width: Length

    var height: Int

}
