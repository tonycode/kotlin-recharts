package recharts


fun LineChartProps.margin(
    top: Int,
    right: Int,
    left: Int,
    bottom: Int,
) {
    this.margin = Margin(top, right, left, bottom)
}

fun LineProps.activeDot(r: Int) {
    this.activeDot = ActiveDot(r)
}
