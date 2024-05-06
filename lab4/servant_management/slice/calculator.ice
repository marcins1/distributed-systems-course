module CalculatorApp {
    interface BasicCalculator {
        int add(int a, int b);
        int subtract(int a, int b);
    };

    interface ExtendedCalculator {
        int multiply(int a, int b);
        int divide(int a, int b);
    };

    interface ScientificCalculator {
        double squareRoot(double a);
        double power(double base, double exponent);
    };

    interface TrygonometricCalculator {
        double sin(double a);
        double cos(double a);
    };
};