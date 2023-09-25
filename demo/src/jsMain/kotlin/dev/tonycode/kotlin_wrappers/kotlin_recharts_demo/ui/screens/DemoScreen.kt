package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens

import antd.Typography
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.line_chart.BiaxialLineChart
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.line_chart.SimpleLineChart
import emotion.react.css
import react.FC
import react.Fragment
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import react.useState
import web.cssom.Color
import web.cssom.px


val DemoScreen = FC<Props> {

    var selectedExample: Examples by useState(Examples.SIMPLE_LINE_CHART)


    Fragment {
        // example selector
        ul {
            css { marginTop = 24.px }

            Examples.entries.forEach { example ->
                li {
                    onClick = {
                        selectedExample = example
                    }

                    Typography.Text {
                        css {
                            if (selectedExample == example) color = Color("blue")
                        }
                        code = true

                        +example.title
                    }
                }
            }
        }

        // example content
        div {
            css { marginTop = 40.px }

            when (selectedExample) {
                Examples.SIMPLE_LINE_CHART -> SimpleLineChart()
                Examples.BIAXIAL_LINE_CHART -> BiaxialLineChart()
            }
        }
    }

}

enum class Examples(val title: String) {
    SIMPLE_LINE_CHART("SimpleLineChart"),
    BIAXIAL_LINE_CHART("BiaxialLineChart"),
}
