package prc.st.q;

import java.util.Stack;

public class ParenthesisCheck {
	static boolean ispar(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				st.push(s.charAt(i));
			} else {
				if (st.isEmpty()) {
					return false;
				}
				char c = st.peek();
				char r = s.charAt(i);
				if ((r == ')' && c != '(') || (r == '}' && c != '{') || (r == ']' && c != '[')) {
					return false;
				}
				st.pop();
			}
		}
		return st.isEmpty();
	}
}
