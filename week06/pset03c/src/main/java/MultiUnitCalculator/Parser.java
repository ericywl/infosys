package MultiUnitCalculator;

/*
 * GRAMMAR
 * operator ::= [PLUS MINUS TIMES DIVIDE]
 *
 */

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {
    private static final double PT_PER_IN = 72;

    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
    }

    /**
     * Type of values.
     */
    private enum ValueType {
        POINTS, INCHES, SCALAR
    }

    ;

    /**
     * Internal value is always in points.
     */
    public class Value {
        final double value;
        final ValueType type;

        Value(double value, ValueType type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            switch (type) {
                case INCHES:
                    return value / PT_PER_IN + " in";
                case POINTS:
                    return value + " pt";
                default:
                    return "" + value;
            }
        }
    }

    // TODO write method spec
    Parser(Lexer lexer) {
        // TODO implement for Problem
    }

    // TODO write method spec
    public Value evaluate() {
        // TODO implement for Problem
        return new Value(1.0, ValueType.INCHES);
    }
}
