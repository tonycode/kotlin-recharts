package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui

import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.components.BuildInfoView
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.DemoScreen
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import web.cssom.Position
import web.cssom.pct
import web.cssom.px


val App = FC<Props> {

    DemoScreen()

    // footer
    div {
        css {
            width = 100.pct
            position = Position.fixed
            bottom = 0.px
        }

        BuildInfoView()
    }

}
