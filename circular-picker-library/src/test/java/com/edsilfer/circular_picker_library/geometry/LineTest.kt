package com.edsilfer.circular_picker_library.geometry

import junit.framework.TestCase.assertEquals
import org.junit.Test

class LineTest {

    @Test
    fun givenTwoKnowPoints_whenCreateLine_expectCorrectLine() {
        // GIVEN
        val p1 = Point(-1f, 8f)
        val p2 = Point(-5f, -1f)

        // WHEN
        val line = Line.from(p1, p2)

        // EXPECT
        assertEquals(9f, line.a)
        assertEquals(-4f, line.b)
        assertEquals(41f, line.c)
        assertEquals(2.25f, line.slope())
        // Assert point 1
        assertEquals(-1f, line.computeX(8))
        assertEquals(8f, line.computeY(-1))
        // Assert point 2
        assertEquals(-5f, line.computeX(-1))
        assertEquals(-1f, line.computeY(-5))
        // Assert angle
        assertEquals(66.03751f, line.angleInDegrees())
        assertEquals(1.152572f, line.angleInRads())
        // Assert distance
        assertEquals(9.848858f, Line.computeDistance(p1, p2))
    }
}