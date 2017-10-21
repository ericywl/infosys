package MultiUnitCalculator;

/*
 * TODO (optional) define your symbols and groups as comment here
 * SYMBOLS
 * numbers: \d+ | '.'
 * operators: + , -, *, /
 * units: scalar, in (inches), pt (point)
 * parentheses: (, )
 *
 * GROUPS
 * OPERATOR: '+' | '-' | '*' | '/'
 * NUMBER: \d+(\.\d+)?
 * UNIT: 'in' | 'pt'
 * OPEN_PAREN: '('
 * CLOSE_PAREN: ')'
 */

/**
 * Token type.
 */
enum Type {
	L_PAREN("("),   // (
	R_PAREN(")"),   // )
	NUMBER(""),	    // 1, 2, 3, 4...
	INCH("in"),     // in
	POINT("pt"),    // pt
	PLUS("+"),		// +
	MINUS("-"),		// -
	TIMES("*"),		// *
	DIVIDE("/"),    // /
    EPSILON("");

    private String s;

	Type(String s) {
		this.s = s;
	}

	String getS() {
        return this.s;
    }
}