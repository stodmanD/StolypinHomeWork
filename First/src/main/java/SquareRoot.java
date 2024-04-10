import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class SquareRoot {
    public static double[] solve(double a, double b, double c, double e) {
        if (abs(a) <= e) {
            throw new ArithmeticException("a не должно быть равно 0");
        }

        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
            throw new ArithmeticException("Ошибка, один из коэффициентов является NAN");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            throw new ArithmeticException("Ошибка, один из коэффициентов является INFINITE");
        }
        double determinant = b * b - 4 * a * c;

        if (determinant < -e) {
            return new double[]{};
        }
        if (abs(determinant) < e) {
            return new double[]{-b / (2 * a), -b / (2 * a)};
        }
        if (determinant > e) {
            return new double[]{(-b + sqrt(determinant)) / (2 * a), (-b - sqrt(determinant)) / (2 * a)};
        }
        return new double[]{};
    }
}