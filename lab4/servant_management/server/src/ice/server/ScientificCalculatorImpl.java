package ice.server;

import CalculatorApp.ScientificCalculator;
import com.zeroc.Ice.Current;

public class ScientificCalculatorImpl implements ScientificCalculator {
    private final String name;

    public ScientificCalculatorImpl(String name) {
        this.name = name;
        System.out.println("ScientificCalculatorImpl created");
    }

    @Override
    public double squareRoot(double a, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating square root of " + a);
        return Math.sqrt(a);
    }

    @Override
    public double power(double base, double exponent, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating power of " + base + " to the exponent of " + exponent);
        return Math.pow(base, exponent);
    }
}
