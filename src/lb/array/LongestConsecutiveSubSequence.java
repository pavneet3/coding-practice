package lb.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubSequence {
	static int findLongestConseqSubseq(int a[], int n) {
		int c = 0;
		Set<Integer> st = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			st.add(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			int t = 1;
			if (!st.contains(a[i] - 1)) {
				int k=a[i];
				while (st.contains(k + 1)) {
					t++;
					k++;
				}
			}
			c = Math.max(c, t);
		}
		return c;
	}
}
