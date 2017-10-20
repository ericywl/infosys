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
    private static final String PLUS = "(\\+)", MINUS = "(-)", TIMES = "(\\*)", DIVIDE = "(/)";

    private static final Map<String, Type> OP_MAP = new HashMap<>();
    static {
        OP_MAP.put("+", Type.PLUS);
        OP_MAP.put("-", Type.MINUS);
        OP_MAP.put("*", Type.TIMES);
        OP_MAP.put("/", Type.DIVIDE);
    }

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+(\\.\\d+)?)");
    private static final Pattern OP_PATTERN =
            Pattern.compile(PLUS +
                    "|" + MINUS +
                    "|" + TIMES +
                    "|" + DIVIDE);

    private static final Pattern CALC =
            Pattern.compile(NUMBER_PATTERN.toString() +
                    "|" + OP_PATTERN.toString());

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
	public Lexer(String input) {
        Matcher matcher = CALC.matcher(input);
        while (matcher.find()) {
            tokens.add(checkType(matcher.group()));
        }
    }

    private Token checkType(String s) {
        if (s.matches(OP_PATTERN.toString())) return new Token(OP_MAP.get(s), s);
        if (s.matches(NUMBER_PATTERN.toString())) return new Token(Type.NUMBER, s);
        return new Token(null, null);
    }

    public static void main(String[] args) {
        Lexer lexer = new Lexer("3+2");
    }
}
