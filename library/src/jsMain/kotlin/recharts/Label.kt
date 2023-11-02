@file:JsModule("recharts")
@file:JsNonModule

package recharts

import react.ComponentClass
import react.Props
import react.ReactNode


/**
 * https://recharts.org/en-US/api/Label
 */
@JsName("Label")
external val Label: ComponentClass<LabelProps>

external interface LabelProps : Props {

    /**
     * The unique id of this component, which will be used to generate unique clip path id internally.
     * This props is suggested to be set in SSR.
     *
     * optional
     */
    var id: String

    /**
     * The value of label, which can be specified by this prop or the children of `Label { ... }`
     */
    var value: String

    /**
     * The position of label relative to the view box
     *
     * optional
     */
    var position: LabelPosition

    var angle: Int

    /**
     * The offset to the specified "position"
     */
    var offset: Int

    /**
     * The option is the custom react element of rendering label
     *
     * optional
     */
    var content: ReactNode?

}
