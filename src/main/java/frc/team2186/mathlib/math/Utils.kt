package frc.team2186.mathlib.math

object Utils {
    fun epsilonEquals(a: Double, b: Double, epsilon: Double): Boolean = a - epsilon <= b && a + epsilon >= b
}
