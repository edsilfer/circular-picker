package com.edsilfer.circular_picker_library.geometry

import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt


/**
 * An API to perform geometric operations on a line
 *
 * General equation of the line
 * ax + by + c = 0
 */
class Line private constructor(p1: Point, p2: Point) {

    companion object {
        fun from(p1: Point, p2: Point): Line {
            return Line(p1, p2)
        }

        fun computeDistance(p1: Point, p2: Point): Float {
            val deltaX = abs(p2.x - p1.x)
            val deltaY = abs(p2.y - p1.y)
            return sqrt(deltaX.pow(2) + deltaY.pow(2))
        }
    }

    /*
    |  x    y   1 |
    | p1x  p1y  1 |
    | p2x  p2y  1 |
     */
    val a: Float = p1.y - p2.y
    val b: Float = p2.x - p1.x
    val c: Float = p1.x * p2.y - p2.x * p1.y

    // slope of the line
    val m: Float = -1 * a / b

    fun computeY(x: Int): Float = -1 * (c + a * x) / b

    fun computeX(y: Int): Float = -1 * (c + b * y) / a

    fun slope() = m

    fun angleInDegrees(): Float {
        val angle: Float = Math.toDegrees(atan(m.toDouble())).toFloat()
        return if (angle < 0) angle + 360f else angle
    }

    fun angleInRads(): Float {
        return (angleInDegrees() * Math.PI / 180).toFloat()
    }
}