package ice.server;

import CalculatorApp.ExtendedCalculator;
import com.zeroc.Ice.Current;

public class ExtendedCalculatorImpl implements ExtendedCalculator {
    private final String name;

    public ExtendedCalculatorImpl(String name) {
        this.name = name;
        System.out.println("ExtendedCalculatorImpl created");
    }

    @Override
    public int multiply(int a, int b, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating multiplication of " + a + " and " + b);
        return a * b;
    }

    @Override
    public int divide(int a, int b, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating division of " + a + " and " + b);
        return a / b;
    }
}
