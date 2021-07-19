package prc.greedy;

import java.util.Arrays;

public class ToyCount {
	static int toyCount(int n, int k, int a[]) {
		Arrays.sort(a);
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (k >= a[i]) {
				c++;
				k -= a[i];
			}
		}
		return c;
	}
}
