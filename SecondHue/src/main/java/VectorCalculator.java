public class VectorCalculator extends AbstractCalculator {
    public VectorCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        return this.add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return this.subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return this.subtract.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return this.subtract.calc(a, b);
    }
}
