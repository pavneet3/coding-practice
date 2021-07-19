package prc.dp;

import java.util.ArrayList;
import java.util.List;

public class MinNumCoins {
	static List<Integer> minPartition(int n) {
		int a[] = new int[] { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
		List<Integer> l = new ArrayList<Integer>();
		while (n != 0) {
			int d = getDenomination(n, a);
			n -= d;
			l.add(d);
		}
		return l;
	}

	private static int getDenomination(int n, int a[]) {
		for (int i = a.length - 1; i >= 0; i--) {
			if (n >= a[i]) {
				return a[i];
			}
		}
		return 0;
	}
}
