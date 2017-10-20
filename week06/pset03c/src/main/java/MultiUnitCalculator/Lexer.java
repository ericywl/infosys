package MultiUnitCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator lexical analyzer.
 */
public class Lexer {
    private static final Map<String, Type> TYPE_MAP = new HashMap<>();
    static {
        TYPE_MAP.put(Type.PLUS.getS(), Type.PLUS);
        TYPE_MAP.put(Type.MINUS.getS(), Type.MINUS);
        TYPE_MAP.put(Type.TIMES.getS(), Type.TIMES);
        TYPE_MAP.put(Type.DIVIDE.getS(), Type.DIVIDE);
        TYPE_MAP.put(Type.L_PAREN.getS(), Type.L_PAREN);
        TYPE_MAP.put(Type.R_PAREN.getS(), Type.R_PAREN);
        TYPE_MAP.put(Type.INCH.getS(), Type.INCH);
        TYPE_MAP.put(Type.POINT.getS(), Type.POINT);
    }

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+(\\.\\d+)?)");
    private static final Pattern PARENS_PATTERN = Pattern.compile("((\\Q(\\E)|(\\Q)\\E))");
    private static final Pattern UNITS_PATTERN = Pattern.compile("(in)|(pt)");
    private static final Pattern OP_PATTERN = Pattern.compile("(\\+)|(-)|(\\*)|(/)");

    private static final Pattern CALC =
            Pattern.compile(NUMBER_PATTERN.toString() +
                    "|" + OP_PATTERN.toString() +
                    "|" + PARENS_PATTERN.toString() +
                    "|" + UNITS_PATTERN.toString());

    private List<Token> tokens = new ArrayList<>();

	/**
	 * Token in the stream.
	 */
	public static class Token {
		final Type type;
		final String text;

		Token(Type type, String text) {
			this.type = type;
			this.text = text;
		}

		Token(Type type) {
			this(type, null);
		}

		@Override
		public String toString() {
            return text + " " + type.toString();
        }
 	}

	@SuppressWarnings("serial")
	static class TokenMismatchException extends Exception {
	}

	// TODO write method spec
	public Lexer(String input) throws TokenMismatchException {
        Matcher matcher = CALC.matcher(input);
        int nextStart;
        int end = 0;

        while (matcher.find()) {
            tokens.add(getToken(matcher.group()));
            nextStart = matcher.start();
            if (nextStart != end) {
                throw new TokenMismatchException();
            }

            end = matcher.end();
        }
    }

    private Token getToken(String s) {
        if (TYPE_MAP.get(s) != null) {
            return new Token(TYPE_MAP.get(s), s);
        }

        return new Token(Type.NUMBER, s);
    }

    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("(3)+2");
            for (Token token : lexer.tokens) {
                System.out.println(token);
            }

        } catch (TokenMismatchException ex) {
            System.out.println("SHIT!");
        }
    }
}
