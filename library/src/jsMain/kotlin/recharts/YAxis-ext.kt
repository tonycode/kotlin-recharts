package recharts

import react.ReactElement


//region YAxisProps.label setters
fun YAxisProps.setLabel(label: String) {
    this.label = label
}

fun YAxisProps.setLabel(label: Number) {
    this.label = label
}

fun YAxisProps.setLabel(label: ReactElement<*>) {
    this.label = label
}
//endregion

object YAxisOrientationFactory {
    fun ofValue(value: String): YAxisOrientation {
        return when (value) {
            YAxisOrientation.right.toString() -> YAxisOrientation.right
            else -> YAxisOrientation.left
        }
    }
}
