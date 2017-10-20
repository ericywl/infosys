package MultiUnitCalculator;

/*
 * TODO (optional) define your symbols and groups as comment here
 * SYMBOLS
 * numbers: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 * operators: + , -, *, /
 * units: scalar, in (inches), pt (point)
 * parentheses: (, )
 */

/**
 * Token type.
 */
enum Type {
	L_PAREN("("),	// (
	R_PAREN(")"),	// )
	NUMBER(""),		// 1, 2, 3, 4...
	INCH("in"),       // in
	POINT("pt"),      // pt
	PLUS("+"),		// +
	MINUS("-"),		// -
	TIMES("*"),		// *
	DIVIDE("/");		// /

    private String s;

	Type(String s) {
		this.s = s;
	}
	
	String getS() {
        return this.s;
    }
}