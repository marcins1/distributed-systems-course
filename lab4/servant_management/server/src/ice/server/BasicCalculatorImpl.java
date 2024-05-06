package ice.server;

import CalculatorApp.BasicCalculator;
import com.zeroc.Ice.Current;

public class BasicCalculatorImpl implements BasicCalculator {
    private final String name;

    public BasicCalculatorImpl(String name) {
        this.name = name;
        System.out.println("BasicCalculatorImpl created");
    }

    @Override
    public int add(int a, int b, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating sum of " + a + " and " + b);
        return a + b;
    }

    @Override
    public int subtract(int a, int b, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating subtraction of " + a + " and " + b);
        return a - b;
    }
}
