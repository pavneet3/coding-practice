package leetcode.apr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> t) {
		if (t.size() == 0) {
			return 0;
		}
		return minPath(t, 1, 0, t.get(0).get(0));
	}

	private static int minPath(List<List<Integer>> t, int i, int j, int m) {
		if (t.size() <= i) {
			return m;
		}
		if (j == t.get(i).size() - 1) {
			return m + minPath(t, i + 1, j, m + t.get(i).get(j));
		} else {
			return m + Math.min(minPath(t, i + 1, j, t.get(i).get(j)), minPath(t, i + 1, j + 1, t.get(i).get(j + 1)));
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> ls = new ArrayList<>(
				Arrays.asList(Arrays.asList(10), Arrays.asList(11, 12), Arrays.asList(14, 13, 1)));
		System.out.println(minimumTotal(ls));
	}
}
