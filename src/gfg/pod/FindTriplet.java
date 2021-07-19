package gfg.pod;

import java.util.Arrays;

public class FindTriplet {
	public static boolean find3Numbers(int a[], int n, int x) {
		Arrays.sort(a);
		for (int i = 2; i < n - 2; i++) {
			int l = i + 1;
			int r = n - 1;
			while (r > l) {
				if (a[i] + a[l] + a[r] == x) {
					return true;
				} else if (a[i] + a[l] + a[r] > x) {
					r--;
				} else {
					l++;
				}
			}
		}
		return false;
	}
}
