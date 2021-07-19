package lb.array;

import java.util.HashSet;
import java.util.Set;

public class IsSubset {
	public String isSubset(long a1[], long a2[], long n, long m) {
		Set<Long> st = new HashSet<>();
		for (int i = 0; i < a1.length; i++) {
			st.add(a1[i]);
		}
		for (int i = 0; i < a2.length; i++) {
			if (!st.contains(a2[i])) {
				return "No";
			}
		}
		return "Yes";
	}
}
