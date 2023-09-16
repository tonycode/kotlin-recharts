package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.components

import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.model.Measurement
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.repository.stubMeasurements
import react.FC
import react.Props
import recharts.CartesianGrid
import recharts.Legend
import recharts.Line
import recharts.LineChart
import recharts.LineType
import recharts.ResponsiveContainer
import recharts.Tooltip
import recharts.XAxis
import recharts.YAxis
import recharts.activeDot
import recharts.strokeDash
import web.cssom.Color
import web.cssom.pct


val SimpleLineChart = FC<Props> {

    ResponsiveContainer {
        width = 100.pct
        height = 480

        LineChart {
            data = stubMeasurements.toTypedArray()

            CartesianGrid {
                strokeDash(3, 3)
            }
            XAxis {
                dataKey = Measurement::date.name
            }
            YAxis()

            Tooltip()
            Legend()

            Line {
                type = LineType.monotone
                dataKey = Measurement::steps.name
                stroke = Color("#8884d8")
                activeDot(8)
            }
        }
    }

}
