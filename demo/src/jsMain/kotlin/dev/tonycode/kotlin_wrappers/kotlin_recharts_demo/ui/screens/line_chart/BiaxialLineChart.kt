package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.line_chart

import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.model.Measurement
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.repository.stubMeasurements
import react.FC
import react.Props
import recharts.CartesianGrid
import recharts.Legend
import recharts.Line
import recharts.LineChart
import recharts.LineType
import recharts.ReferenceArea
import recharts.ReferenceLine
import recharts.ResponsiveContainer
import recharts.Tooltip
import recharts.XAxis
import recharts.YAxis
import recharts.YAxisOrientation
import recharts.activeDot
import recharts.margin
import recharts.strokeDash
import web.cssom.Color
import web.cssom.pct


val BiaxialLineChart = FC<Props> {

    ResponsiveContainer {
        width = 100.pct
        height = 480

        LineChart {
            margin(5, 30, 5, 5)
            data = stubMeasurements.toTypedArray()

            val yAxisLeftId = "left"
            val yAxisRightId = "right"

            CartesianGrid {
                vertical = false
                fill = Color("#ccc")
                fillOpacity = 0.2
                stroke = Color("red")
                strokeDash(4, 1, 2)
            }
            XAxis {
                dataKey = Measurement::date.name
            }
            YAxis {
                yAxisId = yAxisLeftId
                //label = "steps"
            }
            YAxis {
                yAxisId = yAxisRightId
                orientation = YAxisOrientation.right
                //label = "avg bpm"
            }

            Tooltip()
            Legend()

            Line {
                type = LineType.monotone
                dataKey = Measurement::steps.name
                yAxisId = yAxisLeftId
                stroke = Color("#8884d8")
                activeDot(8)
            }
            Line {
                type = LineType.monotone
                dataKey = Measurement::avgBpm.name
                yAxisId = yAxisRightId
                stroke = Color("red")
            }

            ReferenceLine {
                x = stubMeasurements[2].date
                yAxisId = yAxisLeftId
                stroke = Color("black")
                label = "event 1"
            }
            ReferenceArea {
                x1 = stubMeasurements[3].date
                x2 = stubMeasurements[5].date
                yAxisId = yAxisLeftId
                stroke = Color("#ccc")
                label = "vacation"
            }
        }
    }

}
