package lb.array;

import java.util.ArrayList;
import java.util.Collections;

public class MinChocolates {
	public long findMinDiff(ArrayList<Long> a, long n, long m) {
		Collections.sort(a);
		int i = 0;
		int j = (int) m - 1;
		long mn = Long.MAX_VALUE;
		while (j < a.size()) {
			mn = Math.min(a.get(j) - a.get(i), mn);
			j++;
			i++;
		}
		return mn;
	}
}
