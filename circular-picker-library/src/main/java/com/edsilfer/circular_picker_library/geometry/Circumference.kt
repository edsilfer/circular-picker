package com.edsilfer.circular_picker_library.geometry

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * An API to perform geometric operations on a circumference
 *
 * General equation of the circumference
 * (x - xc)^2 + (y - yc) = r^2
 */
class Circumference private constructor(
    private val center: Point,
    private val radius: Float
) {
    companion object {
        fun from(center: Point, radius: Float): Circumference {
            return Circumference(center, radius)
        }
    }

    fun computeY(x: Int): Float = sqrt(radius.pow(2) - (x - center.x).pow(2)) + center.y

    fun computeX(y: Int): Float = sqrt(radius.pow(2) - (y - center.y).pow(2)) + center.x

    fun length(): Float = (2 * Math.PI * radius).toFloat()

    fun intersection(line: Line): List<Point> {
        val angle = line.angleInRads()
        val y = sin(angle) * radius
        val x = cos(angle) * radius
        return listOf(
            Point(center.x + x, center.y + y),
            Point(center.x - x, center.y - y)
        )
    }
}