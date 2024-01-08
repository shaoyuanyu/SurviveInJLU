package com.yusy.surviveinjlu.ui.pages.timetable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yusy.surviveinjlu.ui.AppViewModelProvider
import com.yusy.surviveinjlu.ui.theme.SurviveInJLUTheme

@Composable
fun TimeTableScreen(
    modifier: Modifier = Modifier,
    viewModel: TimeTableViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    TimeTable(
        cols = 7,
        rows = 8,
        height = 140f,
        coursePreviewTable = viewModel.coursesPreviewTable,
        modifier = modifier.padding(5.dp)
    )
}

@Composable
fun TimeTable(
    cols: Int,
    rows: Int,
    height: Float,
    coursePreviewTable: List<List<CoursePreview>>,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // background
        TimeTableBackground(
            cols = cols,
            rows = rows,
            heightDp = height,
            scrollState = scrollState
        )

        // foreground
        TimeTableForeground(
            coursePreviewTable = coursePreviewTable,
            cols = cols,
            rows = rows,
            height = height,
            scrollState = scrollState
        )
    }
}

@Composable
fun TimeTableForeground(
    coursePreviewTable: List<List<CoursePreview>>,
    cols: Int,
    rows: Int,
    height: Float,
    scrollState: ScrollState,
    lineWidthPadding: Float = 0.25f,
    cellMargin: Float = 2f, // 表格内距，cell外距
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = lineWidthPadding.dp)
            .verticalScroll(scrollState)
    ) {
        repeat(cols) { index ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height((rows * height).dp)
            ) {
                coursePreviewTable[index].forEach { coursePreview ->
                    Box(
                        modifier = Modifier.padding(cellMargin.dp)
                    ) {
                        val cellHeight = height * coursePreview.courseSessionNum +
                                (coursePreview.courseSessionNum-1) * lineWidthPadding -
                                2 * cellMargin

                        CourseCell(
                            courseName = coursePreview.courseName,
                            courseCellHeight = cellHeight,
                            isSpare = coursePreview.isSpare,
                            courseCellColor = coursePreview.cellColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CourseCell(
    courseName: String,
    courseCellHeight: Float,
    modifier: Modifier = Modifier,
    isSpare: Boolean = true,
    courseCellColor: Color = if (isSpare) Color.Transparent else Color.Gray,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height((courseCellHeight).dp)
            .clip(RoundedCornerShape(8.dp))
            .background(courseCellColor)
    ) {
        Text(
            text = courseName,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun TimeTableBackground(
    cols: Int,
    rows: Int,
    heightDp: Float,
    scrollState: ScrollState,
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Gray,
    lineWidthDp: Float = 0.25f,
) {
    // use px in canvas instead of dp
    var heightPx: Float
    var lineWidthPx: Float
    with(LocalDensity.current) {
        heightPx = heightDp.dp.toPx()
        lineWidthPx = lineWidthDp.dp.toPx()
    }

    Box(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .height((heightDp * rows).dp)
                .border(width = lineWidthDp.dp, color = Color.Blue)
        ) {
            val canvasWidth = size.width

            repeat(cols+1) {
                val x = canvasWidth / cols * it
                drawLine(
                    start = Offset(x = x, y = 0f),
                    end = Offset(x = x, y = heightPx * rows),
                    strokeWidth = lineWidthPx,
                    color = lineColor
                )
            }

            repeat(rows+1) {
                val y = heightPx * it
                drawLine(
                    start = Offset(x = 0f, y = y),
                    end = Offset(x = canvasWidth, y = y),
                    strokeWidth = lineWidthPx,
                    color = lineColor
                )
            }
        }
    }
}

@Preview
@Composable
fun TablePreview() {
    SurviveInJLUTheme {
    }
}
