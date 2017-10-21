package MultiUnitCalculator;

/*
 * GRAMMAR
 * expression ::= term OPERATOR term
 * term ::= (NUMBER (UNIT)?) | argument
 * argument ::= (OPEN_PAREN expression CLOSE_PAREN) (UNIT)?
 */

import MultiUnitCalculator.Lexer.Token;

import java.util.LinkedList;

/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {
    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
        ParserException(String message) {
            super(message);
        }
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
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            double temp_value = Math.round(value * 10000) / 10000.0;

            switch (type) {
                case INCHES:
                    return temp_value + " in";
                case POINTS:
                    return temp_value + " pt";
                default:
                    return "" + temp_value;
            }
        }
    }

    private static final double PT_PER_IN = 72;

    private LinkedList<Token> tokenList;
    private Token head;

    // TODO write method spec
    Parser(Lexer lexer) {
        this.tokenList = new LinkedList<Token>(lexer.getTokenList());
        this.head = tokenList.getFirst();
    }

    private void nextToken() {
        tokenList.pop();
        if (!tokenList.isEmpty()) {
            head = tokenList.getFirst();
        } else {
            head = new Token(Type.EPSILON, "");
        }
    }

    private Value expression() {
        Value term1 = term();
        if (head.type == Type.EPSILON) {
            return term1;
        }

        Type operation = operator();
        Value term2 = term();

        return operate(term1, term2, operation);
    }

    private Value term() throws ParserException {
        if (head.type == Type.NUMBER) {
            double value = Double.parseDouble(head.text);
            nextToken();

            ValueType unit = units();
            return new Value(value, unit);
        }

        if (head.type == Type.L_PAREN) {
            Value arg = argument();
            nextToken();

            ValueType unit = units();
            if (arg.type == ValueType.SCALAR && unit != ValueType.SCALAR) {
                return new Value(arg.value, ValueType.INCHES);
            }

            return convert(arg, unit);
        }

        throw new ParserException("\nUnknown term: " + head.type);
    }

    private Value argument() {
        nextToken();
        Value arg = expression();

        if (head.type == Type.R_PAREN) {
            return arg;
        }

        throw new ParserException("\nUnknown argument: " + head.type);
    }

    private ValueType units() {
        switch (head.type) {
            case INCH:
                nextToken();
                return ValueType.INCHES;

            case POINT:
                nextToken();
                return ValueType.POINTS;

            default:
                return ValueType.SCALAR;
        }
    }

    private Value convert(Value val, ValueType unit) {
        if (val.type == unit) {
            return val;
        }

        if (unit == ValueType.INCHES) {
            return new Value(val.value / PT_PER_IN, unit);
        }

        if (val.type == ValueType.INCHES) {
            return new Value(val.value * PT_PER_IN, unit);
        }

        return new Value(val.value, unit);
    }

    private Type operator() throws ParserException {
        if (head.type == Type.PLUS || head.type == Type.MINUS
                || head.type == Type.TIMES || head.type == Type.DIVIDE) {
            Type output = head.type;
            nextToken();
            return output;
        }

        throw new ParserException("\nUnknown operator: " + head.type);
    }

    private Value operate(Value val1, Value val2, Type operation)
            throws ArithmeticException, ParserException {
        ValueType resultType = decideType(val1.type, val2.type, operation);
        Value val1_temp = convert(val1, resultType);
        Value val2_temp = convert(val2, resultType);
        double resultValue = 0;

        switch (operation) {
            case PLUS:
                resultValue = val1_temp.value + val2_temp.value;
                break;

            case MINUS:
                resultValue = val1_temp.value - val2_temp.value;
                break;

            case TIMES:
                if (val1.type != val2.type
                        && val1.type != ValueType.SCALAR && val2.type != ValueType.SCALAR) {
                    resultValue = val1_temp.value * val2_temp.value;
                } else {
                    resultValue = val1.value * val2.value;
                }
                break;

            case DIVIDE:
                if (val2_temp.value == 0) {
                    throw new ArithmeticException("\nCannot divide by zero.");
                }

                if (val1.type != val2.type
                        && val1.type != ValueType.SCALAR && val2.type != ValueType.SCALAR) {
                    resultValue = val1_temp.value / val2_temp.value;
                } else {
                    resultValue = val1.value / val2.value;
                }
                break;

            default:
                throw new ParserException("\nUnknown operation: " + operation);
        }

        return new Value(resultValue, resultType);
    }

    private ValueType decideType(ValueType t1, ValueType t2, Type operation) {
        if (operation == Type.DIVIDE) {
            if (t1 == t2) {
                return ValueType.SCALAR;
            }

            if (t1 != ValueType.SCALAR && t2 != ValueType.SCALAR) {
                return ValueType.SCALAR;
            }
        }

        if (t1 == ValueType.SCALAR) {
            return t2;
        }

        return t1;
    }

    // TODO write method spec
    public Value evaluate() throws ParserException{
        Value result = null;

        if (head.type == Type.NUMBER || head.type == Type.L_PAREN) {
            result = expression();
        } else {
            throw new ParserException("\nUnknown evaluate: " + head.type);
        }

        if (tokenList.isEmpty()) {
            return result;
        }

        throw new ParserException("\nOrder not explicit.");
    }

    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("72in / 4in");
            Parser parser = new Parser(lexer);
            System.out.println(parser.evaluate().toString());
        } catch (Lexer.TokenMismatchException | ParserException ex) {
            System.out.println(ex);
        }
    }
}
