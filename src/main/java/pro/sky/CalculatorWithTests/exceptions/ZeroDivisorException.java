package pro.sky.CalculatorWithTests.exceptions;

public class ZeroDivisorException extends RuntimeException {
    public ZeroDivisorException() {
        super("Нельзя делить на ноль!");
    }
}
