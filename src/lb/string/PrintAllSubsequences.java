package lb.string;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubsequences {

	static Set<String> allSubsequences(String s) {
		Set<String> ls = new HashSet<String>();
		populateSubsequences(s, "", ls);
		return ls;
	}

	private static void populateSubsequences(String s, String s1, Set<String> ls) {
		if (s.equals("")) {
			if (!s1.equals("")) {
				ls.add(s1);
			}
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			populateSubsequences(s.substring(i + 1), s1 + s.charAt(0), ls);
			populateSubsequences(s.substring(i + 1), s1, ls);
		}
	}

	public static void main(String[] args) {
		System.out.println(allSubsequences("abc"));
	}
}
