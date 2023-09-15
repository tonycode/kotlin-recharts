package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens

import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.components.SimpleLineChart
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import web.cssom.px


val DemoScreen = FC<Props> {

    div {
        css { marginTop = 24.px }

        SimpleLineChart()
    }

}
