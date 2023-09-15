@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props


@JsName("XAxis")
external val XAxis : ComponentClass<XAxisProps>

external interface XAxisProps : Props {

    var dataKey: String

    var allowDuplicatedCategory: Boolean

}
