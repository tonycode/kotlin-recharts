package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens

import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.repository.stubMeasurements
import react.FC
import react.Props
import recharts.CartesianGrid
import recharts.Legend
import recharts.Line
import recharts.LineChart
import recharts.ResponsiveContainer
import recharts.Tooltip
import recharts.XAxis
import recharts.YAxis
import recharts.activeDot
import recharts.strokeDash
import web.cssom.pct


val DemoScreen = FC<Props> {

    ResponsiveContainer {
        width = 100.pct
        height = 600

        LineChart {
            data = stubMeasurements.toTypedArray()

            CartesianGrid {
                strokeDash(3, 3)
            }
            XAxis {
                dataKey = "day"
            }
            YAxis()

            Tooltip()
            Legend()

            Line {
                type = "monotone"
                dataKey = "value"
                stroke = "#8884d8"
                activeDot(8)
            }
        }
    }

}
