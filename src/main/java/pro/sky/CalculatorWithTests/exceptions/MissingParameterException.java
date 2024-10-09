package pro.sky.CalculatorWithTests.exceptions;

public class MissingParameterException extends RuntimeException {
    public MissingParameterException() {
        super("Отсутсвуен один или оба аргумента!");
    }
}
