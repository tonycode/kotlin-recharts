package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.ui.screens.line_chart

import antd.Checkbox
import antd.Direction
import antd.Radio
import antd.RadioOptionType
import antd.Size
import antd.Space
import antd.Typography
import antd.setOptions
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.model.Measurement
import dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.repository.stubMeasurements
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.input
import react.useState
import recharts.CartesianGrid
import recharts.Legend
import recharts.Line
import recharts.LineChart
import recharts.LineType
import recharts.ResponsiveContainer
import recharts.Tooltip
import recharts.XAxis
import recharts.YAxis
import recharts.YAxisOrientation
import recharts.YAxisOrientationFactory
import recharts.activeDot
import web.cssom.Color
import web.cssom.pct
import web.cssom.px


val SimpleLineChart = FC<Props> {

    var cartesianGridHorizontal: Boolean by useState(true)
    var cartesianGridVertical: Boolean by useState(true)
    var cartesianGridStrokeDasharray: String by useState("3 3")

    var yAxisHide: Boolean by useState(false)
    var yAxisOrientation: YAxisOrientation by useState(YAxisOrientation.left)

    var lineIsAnimationActive: Boolean by useState(true)


    Space {
        css { width = 100.pct }
        direction = Direction.vertical
        size = Size.large

        // chart
        ResponsiveContainer {
            width = 100.pct
            height = 480

            LineChart {
                data = stubMeasurements.toTypedArray()

                CartesianGrid {
                    horizontal = cartesianGridHorizontal
                    vertical = cartesianGridVertical
                    strokeDasharray = cartesianGridStrokeDasharray
                }
                XAxis {
                    dataKey = Measurement::date.name
                }
                YAxis {
                    hide = yAxisHide
                    orientation = yAxisOrientation
                }

                Tooltip()
                Legend()

                Line {
                    type = LineType.monotone
                    dataKey = Measurement::steps.name
                    stroke = Color("#8884d8")
                    activeDot(8)
                    isAnimationActive = lineIsAnimationActive
                }
            }
        }

        // controller
        Space {
            css { marginLeft = 24.px; marginRight = 24.px }
            direction = Direction.vertical

            //region CartesianGrid
            Typography.Title {
                level = 3
                +"CartesianGrid"
            }

            Space {
                direction = Direction.horizontal

                Typography.Text {
                    code = true
                    +"horizontal"
                }

                Checkbox {
                    checked = cartesianGridHorizontal
                    onChange = { cartesianGridHorizontal = it.target.checked }
                }
            }

            Space {
                direction = Direction.horizontal

                Typography.Text {
                    code = true
                    +"vertical"
                }

                Checkbox {
                    checked = cartesianGridVertical
                    onChange = { cartesianGridVertical = it.target.checked }
                }
            }

            Space {
                direction = Direction.horizontal

                val isPropDisabled = (cartesianGridHorizontal == false && cartesianGridVertical == false)

                Typography.Text {
                    code = true
                    disabled = isPropDisabled

                    +"strokeDasharray"
                }

                input {
                    value = cartesianGridStrokeDasharray
                    disabled = isPropDisabled

                    onChange = { cartesianGridStrokeDasharray = it.target.value }
                }
            }
            //endregion

            //region YAxis
            Typography.Title {
                level = 3
                +"YAxis"
            }

            Space {
                direction = Direction.horizontal

                Typography.Text {
                    code = true
                    +"hide"
                }

                Checkbox {
                    checked = yAxisHide
                    onChange = { yAxisHide = it.target.checked }
                }
            }

            Space {
                direction = Direction.horizontal

                val isPropDisabled = (yAxisHide == true)

                Typography.Text {
                    code = true
                    +"orientation"
                }

                Radio.Group {
                    setOptions(
                        YAxisOrientation.left.toString(),
                        YAxisOrientation.right.toString(),
                    )
                    value = yAxisOrientation.toString()
                    disabled = isPropDisabled

                    optionType = RadioOptionType.button

                    onChange = {
                        console.dir(it)
                        yAxisOrientation = YAxisOrientationFactory.ofValue(it.target.value)
                    }
                }
            }
            //endregion

            //region Line
            Typography.Title {
                level = 3
                +"Line"
            }

            Space {
                direction = Direction.horizontal

                Typography.Text {
                    code = true
                    +"isAnimationActive"
                }

                Checkbox {
                    checked = lineIsAnimationActive
                    onChange = { lineIsAnimationActive = it.target.checked }
                }
            }
            //endregion
        }
    }

}
