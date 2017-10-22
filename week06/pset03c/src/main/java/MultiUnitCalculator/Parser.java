package MultiUnitCalculator;

/*
 * GRAMMAR
 * expression ::= term (OPERATOR term)?
 * term ::= (NUMBER | argument) (UNITS)?
 * argument ::= (OPEN_PAREN expression CLOSE_PAREN)
 */

import MultiUnitCalculator.Lexer.Token;

import java.util.LinkedList;

/**
 * Calculator parser. All values in POINTS.
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

    /**
     * Internal value is stored in POINTS.
     * ie. 2in is stored as value = 144.0, type = INCH
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
            final double div = 10000.0;
            double val;
            if (type == ValueType.INCHES) {
                val = Math.round(value / PT_PER_IN * div) / div;
            } else {
                val = Math.round(value * div) / div;
            }


            switch (type) {
                case INCHES:
                    return val + " in";
                case POINTS:
                    return val + " pt";
                default:
                    return "" + val;
            }
        }
    }

    private static final double PT_PER_IN = 72;

    private LinkedList<Token> tokenLinkedList;
    private Token head;

    /**
     * Casts List into LinkedList to use pop() and getFirst().
     * Sets head to the first element of LinkedList.
     *
     * @param lexer: the tokenList that lexer carries is the one needed
     */
    Parser(Lexer lexer) {
        this.tokenLinkedList = new LinkedList<Token>(lexer.getTokenList());
        this.head = tokenLinkedList.getFirst();
    }

    /**
     * Access the next element using pop() and getFirst().
     * If the list is empty, set head to a token with EPSILON type, signifying end of list.
     */
    private void nextToken() {
        tokenLinkedList.pop();
        if (!tokenLinkedList.isEmpty()) {
            head = tokenLinkedList.getFirst();
        } else {
            head = new Token(Type.EPSILON, "");
        }
    }

    /**
     * If the list is not empty, the input has something else behind the expression.
     *
     * @return expression
     * @throws ParserException
     * Invalid starting symbol: Can only start with NUMBER or '('.
     * Order not explicit: Can only have expression grammar.
     */
    public Value evaluate() throws ParserException{
        Value result;

        if (head.type == Type.NUMBER || head.type == Type.L_PAREN) {
            result = expression();
        } else {
            throw new ParserException("\nInvalid starting symbol: " + head.type);
        }

        if (tokenLinkedList.isEmpty()) {
            return result;
        }

        throw new ParserException("\nOrder not explicit.");
    }

    /**
     * If there's only 1 term, return it.
     * This is because my grammar has argument inside term, so it allows this.
     *
     * Else include the operator and another term.
     *
     * @return term (OPERATOR term)?
     */
    private Value expression() {
        Value term1 = term();
        if (head.type == Type.EPSILON) {
            return term1;
        }

        Type operation = operator();
        if (operation == Type.R_PAREN) {
            return term1;
        }

        Value term2 = term();

        return operate(term1, term2, operation);
    }

    /**
     * If the term starts with a NUMBER, parse the NUMBER and possibly UNITS.
     * If the units is INCHES, multiply by PT_PER_IN because values are stored as POINTS.
     *
     * If the term starts with a L_PAREN, parse the argument and possible trailing UNITS.
     * When parsing the trailing units, check if the argument is a SCALAR.
     * This is because (2 + 3)in should be 5in.
     *
     * @return NUMBER (UNITS)? or argument (UNITS)?
     * @throws ParserException
     * Unknown term: Can only start with NUMBER or '('.
     */
    private Value term() throws ParserException {
        if (head.type == Type.NUMBER) {
            double value = Double.parseDouble(head.text);
            nextToken();

            ValueType unit = units();
            if (unit == ValueType.INCHES) {
                value *= PT_PER_IN;
            }

            return new Value(value, unit);
        }

        if (head.type == Type.L_PAREN) {
            Value arg = argument();
            nextToken();

            ValueType unit = units();
            if (arg.type == ValueType.SCALAR && unit == ValueType.INCHES) {
                return new Value(arg.value * PT_PER_IN, unit);
            }

            if (unit == ValueType.SCALAR) {
                return arg;
            }

            return new Value(arg.value, unit);
        }

        throw new ParserException("\nUnknown term: " + head.type);
    }

    /**
     * Only term() calls argument().
     * Since OPEN_PAREN is already checked,
     * proceed to parse expression and only return it when the CLOSE_PAREN is found.
     *
     * @return OPEN_PAREN expression CLOSE_PAREN
     * @throws ParserException
     * Not closing parenthesis: The expression must be followed by a closing bracket.
     */
    private Value argument() throws ParserException {
        nextToken();
        Value arg = expression();

        if (head.type == Type.R_PAREN) {
            return arg;
        }

        throw new ParserException("\nNot closing parenthesis: " + head.type);
    }

    /**
     * units() method exists for convenience and makes the code look more organized.
     * It also proceeds to next element if units are detected, so as to end off at the same position
     * compared to when no units are detected.
     *
     * @return UNITS
     */
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

    /**
     * operator() method exists for convenience and makes the code look more organized.
     *
     * @return OPERATOR
     * @throws ParserException
     * Argument should contain expression: If a CLOSE_PAREN is detected before an OPERATOR, the
     *                                     argument does not contain an expression but only a term.
     * Not operator: If it's not end, the first term should be followed by a supported operator.
     */
    private Type operator() throws ParserException {
        if (head.type == Type.PLUS || head.type == Type.MINUS
                || head.type == Type.TIMES || head.type == Type.DIVIDE) {
            Type output = head.type;
            nextToken();
            return output;
        }

        if (head.type == Type.R_PAREN) {
            throw new ParserException("\nArgument should contain expression.");
        }

        throw new ParserException("\nNot operator: " + head.type);
    }

    /**
     * Perform addition and subtraction while converting the units.
     * Multiplication and division is slightly more special because of some requirements
     * ie. INCHES * INCHES = INCHES
     * ie. INCHES / INCHES = SCALAR
     *
     * The units are decided by decideType().
     *
     * @param val1: first term
     * @param val2: second term
     * @param operation: the operator in-between
     * @return result of expression
     * @throws ArithmeticException: Cannot divide by zero.
     * @throws ParserException
     * Unknown operation: execution should not reach this stage, but just in case...
     */
    private Value operate(Value val1, Value val2, Type operation)
            throws ArithmeticException, ParserException {
        ValueType resultType = decideType(val1.type, val2.type, operation);
        double resultValue = 0;

        switch (operation) {
            case PLUS:
                resultValue = val1.value + val2.value;
                break;

            case MINUS:
                resultValue = val1.value - val2.value;
                break;

            case TIMES:
                if (val1.type != val2.type
                        && val1.type != ValueType.SCALAR && val2.type != ValueType.SCALAR) {
                    resultValue = val1.value * val2.value;

                } else {
                    resultValue = val1.value * val2.value;
                }

                if (val1.type == val2.type && val1.type == ValueType.INCHES) {
                    resultValue /= PT_PER_IN;
                }

                break;

            case DIVIDE:
                if (val2.value == 0) {
                    throw new ArithmeticException("\nCannot divide by zero.");
                }

                if (val1.type != val2.type
                        && val1.type != ValueType.SCALAR && val2.type != ValueType.SCALAR) {
                    resultValue = val1.value / val2.value;
                } else {
                    resultValue = val1.value / val2.value;
                }
                break;

            default:
                throw new ParserException("\nUnknown operation: " + operation);
        }

        return new Value(resultValue, resultType);
    }

    /**
     * If operation == DIVIDE, check if both units are equal ie. INCHES / INCHES = SCALAR.
     * Also check if the units are POINTS and INCHES because that also returns SCALAR.
     *
     * If the units of first term is SCALAR, the units of second term is used
     * ie. SCALAR / INCHES = INCHES
     *
     * @param t1: type of first term
     * @param t2: type of second term
     * @param operation: to check if it's DIVIDE
     * @return units for the whole expression
     */
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

    // Test
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("(3in*2.4)pt ");
            Parser parser = new Parser(lexer);
            System.out.println(parser.evaluate().toString());
        } catch (Lexer.TokenMismatchException | ParserException ex) {
            System.out.println(ex);
        }
    }
}
