

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SquareRoot.class)
public class SquareRootTest {

    private SquareRoot squareRoot;
    private double epsilon = 1e-11;

    @Test
    void getSquareRoot() {
        assertArrayEquals(squareRoot.solve(5.2, 15.1, 3.0, epsilon), new double[]{-0.2145235681229893, -2.6893225857231644});
//        тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
        assertArrayEquals(squareRoot.solve(1, 0, 1, epsilon), new double[]{});
//        тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
        assertArrayEquals(squareRoot.solve(1, 0, -1, epsilon), new double[]{1, -1});
//        тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1)
        assertArrayEquals(squareRoot.solve(1, 2, 1, epsilon), new double[]{-1, -1});
//        тест, который проверяет, что коэффициент a не может быть равен 0. В этом случае solve выбрасывает исключение
        Throwable exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve(0, 2, 1, epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("a не должно быть равно 0"));
//        С учетом того, что дискриминант тоже нельзя сравнивать с 0 через знак равенства, подобрать такие коэффициенты квадратного уравнения для случая одного корня кратности два, чтобы дискриминант был отличный от нуля, но меньше заданного эпсилон. Эти коэффициенты должны заменить коэффициенты в тесте из п. 7.
        assertArrayEquals(squareRoot.solve(0.999999999999999, 2, 0.999999999999999, epsilon), new double[]{-1.000000000000001, -1.000000000000001});
//        тест, который проверяет, что коэффициенты не могут быть NAN. В этом случае solve выбрасывает исключение
        exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve(1, sqrt(-1), 1, epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("Ошибка, один из коэффициентов является NAN"));
        exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve(sqrt(-1), 1, 1, epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("Ошибка, один из коэффициентов является NAN"));
        exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve(1, 1, sqrt(-1), epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("Ошибка, один из коэффициентов является NAN"));
//        тест, который проверяет, что коэффициенты не могут быть INFINITE. В этом случае solve выбрасывает исключение
        exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve(1, (1.0 / 0.0), 1, epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("Ошибка, один из коэффициентов является INFINITE"));
        exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve((1.0 / 0.0), 1, 1, epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("Ошибка, один из коэффициентов является INFINITE"));
        exception = assertThrows(
                ArithmeticException.class,
                () -> {
                    squareRoot.solve(1, 1, (1.0 / 0.0), epsilon);
                }
        );
        assertTrue(exception.getMessage().contains("Ошибка, один из коэффициентов является INFINITE"));
    }

}
