package recharts


fun CartesianGridProps.strokeDash(dashWidth: Int, gapWidth: Int) {
    this.strokeDasharray = "$dashWidth $gapWidth"
}

fun CartesianGridProps.strokeDash(vararg widths: Int) {
    this.strokeDasharray = widths.joinToString(" ")
}
