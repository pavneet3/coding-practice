package prc.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
	public static int josephus(int n, int k) {
		List<Integer> l = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			l.add(i);
		}
		return solve(l, n, k, 0);
	}

	private static int solve(List<Integer> l, int n, int k, int s) {
		if (n == 1) {
			return l.get(0);
		}
		s = (s + (k - 1)) % n;
		l.remove(l.get(s));
		return solve(l, n - 1, k, s);
	}

	public static void main(String[] args) {
		System.out.println(josephus(3, 2));
	}
}
