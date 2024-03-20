package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens

import antd.Tabs
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.line_chart.BiaxialLineChart
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.line_chart.SimpleLineChart
import js.objects.jso
import react.FC
import react.Props
import react.create
import react.useState


val DemoScreen = FC<Props>("DemoScreen") {

    var selectedExample: Examples by useState(Examples.SIMPLE_LINE_CHART)


    Tabs {
        activeKey = selectedExample.name

        items = arrayOf(
            jso {
                key = Examples.SIMPLE_LINE_CHART.name
                label = Examples.SIMPLE_LINE_CHART.title
                children = SimpleLineChart.create()
            },
            jso {
                key = Examples.BIAXIAL_LINE_CHART.name
                label = Examples.BIAXIAL_LINE_CHART.title
                children = BiaxialLineChart.create()
            },
        )

        onChange = { selectedExample = Examples.valueOf(it) }
    }

}

enum class Examples(val title: String) {
    SIMPLE_LINE_CHART("SimpleLineChart"),
    BIAXIAL_LINE_CHART("BiaxialLineChart"),
}
