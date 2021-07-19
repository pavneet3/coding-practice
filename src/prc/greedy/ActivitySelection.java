package prc.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ActivitySelection {
	public static int activitySelection(int s[], int e[], int n) {
		List<int[]> l = new LinkedList<int[]>();
		for (int i = 0; i < n; i++) {
			l.add(new int[] { s[i], e[i] });
		}
		Collections.sort(l, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		int i = 0;
		int j = 1;
		int c = 1;
		while (j < l.size()) {
			if (l.get(i)[1] < l.get(j)[0]) {
				c++;
				i = j;
			}
			j++;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(activitySelection(new int[] { 1, 4, 4, 8, 7 }, new int[] { 10, 7, 8, 8, 10 }, 4));
	}
}
