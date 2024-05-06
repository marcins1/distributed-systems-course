package ice.server;

import CalculatorApp.TrygonometricCalculator;
import com.zeroc.Ice.Current;

public class TrigonometricCalculatorImpl implements TrygonometricCalculator {
    private final String name;

    public TrigonometricCalculatorImpl(String name) {
        this.name = name;
        System.out.println("TrigonometricCalculatorImpl created");
    }

    @Override
    public double sin(double a, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating sinus of " + a);
        return Math.sin(a);
    }

    @Override
    public double cos(double a, Current current) {
        System.out.println("[(" + name +  ")(" + current.id.name +  ")(" + current.id.category + ")] Calculating cosinus of " + a);
        return Math.cos(a);
    }
}
