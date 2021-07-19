package lb.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairCount {
	int getPairsCount(int[] a, int n, int k) {
		Map<Integer, Set<Integer>> m = new HashMap<>();
		int c = 0;
		for (int i = 0; i < n; i++) {
			Set<Integer> st = m.getOrDefault(a[i], new HashSet<>());
			st.add(i);
			m.put(a[i], st);
		}
		for (int i = 0; i < a.length; i++) {
			int d = k - a[i];
			if (d < 0) {
				continue;
			}
			if (m.containsKey(d)) {
				for (Integer v : m.get(d)) {
					if (v == i) {
						continue;
					}
					c++;
				}
			}
		}
		return c / 2;
	}
}
