package prc.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class CandyShop {
	static ArrayList<Integer> candyStore(int a[], int n, int k) {
		Arrays.sort(a);
		int mn = 0;
		int j = a.length;
		for (int i = 0; i < j; i++) {
			mn += a[i];
			j -= k;
		}
	}
}
