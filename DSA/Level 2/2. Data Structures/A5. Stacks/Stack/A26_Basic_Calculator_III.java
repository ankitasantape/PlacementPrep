/*
1. Implement a basic calculator to evaluate a simple expression string.
2. String will contain only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. 
3. All intermediate results will be in the range of [-2^31, 2^31 - 1].
Constraints
1. 1 <= s.length <= 10^4
2. s consists of digits, '+', '-', '*', '/', '(', and ')'.
3. s is a valid expression.
Sample Input
2*(5+5*2)/3+(6/2+8)
Sample Output
21
 
*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A26_Basic_Calculator_III {

	public static int calculate(String s) {
		Stack<Integer> vs = new Stack<>();
		Stack<Character> os = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (Character.isDigit(ch) == true) {
				int val = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i)) == true) {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				vs.push(val);
				i--;
			} else if (ch == '(') {
				os.push(ch);
			} else if (ch == ')') {
				while (os.size() > 0 && os.peek() != '(') {
					int b = vs.pop();
					int a = vs.pop();
					char opr = os.pop();
					vs.push(evaluate(a, b, opr));
				}
				os.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (os.size() > 0 && os.peek() != '(' && priority(os.peek()) >= priority(ch)) {
					int b = vs.pop();
					int a = vs.pop();
					char opr = os.pop();
					vs.push(evaluate(a, b, opr));
				}
				os.push(ch);
			}
		}

		while (os.size() > 0) {
			int b = vs.pop();
			int a = vs.pop();
			char opr = os.pop();
			vs.push(evaluate(a, b, opr));
		}

		return vs.peek();
	}

	public static int evaluate(int a, int b, char opr) {
		if (opr == '+') {
			return a + b;
		} else if (opr == '-') {
			return a - b;
		} else if (opr == '*') {
			return a * b;
		} else {
			return a / b;
		}
	}

	public static int priority(char opr) {
		if (opr == '+' || opr == '-') {
			return 1;
		} else {
			return 2;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int result = calculate(read.readLine());
		System.out.println(result);

	}

}
