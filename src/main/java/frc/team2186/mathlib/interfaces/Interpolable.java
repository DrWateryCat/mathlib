package frc.team2186.mathlib.interfaces;

public interface Interpolable<T> {
    T interpolate(T other, double x);
}
