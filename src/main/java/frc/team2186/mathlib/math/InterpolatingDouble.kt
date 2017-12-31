package frc.team2186.mathlib.math

import frc.team2186.mathlib.interfaces.Interpolable
import frc.team2186.mathlib.interfaces.InverseInterpolable


class InterpolatingDouble(var value: Double) : Interpolable<InterpolatingDouble>,
        InverseInterpolable<InterpolatingDouble>,
                            Comparable<InterpolatingDouble> {

    override fun interpolate(other: InterpolatingDouble, x: Double): InterpolatingDouble {
        val delta = other.value - value
        val search = delta * x + value
        return InterpolatingDouble(search)
    }

    override fun inverseInterpolate(upper: InterpolatingDouble, lower: InterpolatingDouble): Double {
        val upperToLower = upper.value - value
        if (upperToLower <= 0.0) {
            return 0.0
        }
        val queryLower = lower.value - value
        if (queryLower <= 0.0) {
            return 0.0
        }
        return queryLower / upperToLower
    }

    override fun compareTo(other: InterpolatingDouble): Int {
        return when {
            other.value < value -> 1
            other.value > value -> -1
            else -> 0
        }
    }
}