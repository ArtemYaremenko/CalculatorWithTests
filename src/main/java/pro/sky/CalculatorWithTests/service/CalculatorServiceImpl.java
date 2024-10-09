package pro.sky.CalculatorWithTests.service;

import org.springframework.stereotype.Service;
import pro.sky.CalculatorWithTests.exceptions.MissingParameterException;
import pro.sky.CalculatorWithTests.exceptions.ZeroDivisorException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    String greeting = "Добро пожаловать в калькулятор!";

    @Override
    public String greetings() {
        return greeting;
    }

    @Override
    public int sum(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new MissingParameterException();
        }
        return a + b;
    }

    @Override
    public int diff(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new MissingParameterException();
        }
        return a - b;
    }

    @Override
    public int multiply(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new MissingParameterException();
        }
        return a * b;
    }

    @Override
    public int divide(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new MissingParameterException();
        }
        if (b == 0) {
            throw new ZeroDivisorException();
        }
        return a / b;
    }
}
