package MultiUnitCalculator;

/*
 * SYMBOLS
 * numbers: \d+ | '.'
 * operators: + , -, *, /
 * units: scalar, in (inches), pt (point)
 * parentheses: (, )
 *
 * GROUPS
 * OPERATOR: '+' | '-' | '*' | '/'
 * NUMBER: \d+(\.\d+)?
 * UNITS: 'in' | 'pt'
 * OPEN_PAREN: '('
 * CLOSE_PAREN: ')'
 */

/**
 * Token type.
 */
enum Type {
	L_PAREN("("),   // (
	R_PAREN(")"),   // )
	INCH("in"),     // in
	POINT("pt"),    // pt
	PLUS("+"),		// +
	MINUS("-"),		// -
	TIMES("*"),		// *
	DIVIDE("/"),    // /
    NUMBER(""),	    // 1, 2, 3, 4...
    EPSILON("");    // end of input

    private String s;

	Type(String s) {
		this.s = s;
	}

	String getS() {
        return this.s;
    }
}