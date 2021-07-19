package prc.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
	static List<List<Integer>> combinationSum(int a[], int n, int s) {
		Arrays.sort(a);
		reverseArray(a);
		List<List<Integer>> r = new ArrayList<>();
		sumSubsets(a, r, "", n, s,new HashSet<String>());
		return r;
	}

	private static void sumSubsets(int[] a, List<List<Integer>> r, String rs, int n, int s, Set<String> st) {
		if (s == 0 && !st.contains(rs)) {
			List<Integer> l = new ArrayList<Integer>();
			for (String v : rs.split("-")) {
				if (v.equals("")) {
					continue;
				}
				l.add(Integer.parseInt(v));
			}
			st.add(rs);
			r.add(l);
			return;
		}
		if (n == 0) {
			return;
		}
		if (s < 0) {
			return;
		}
		sumSubsets(a, r, rs + "-" + a[n - 1], n - 1, s - a[n - 1], st);
		sumSubsets(a, r, rs, n - 1, s, st);
	}

	private static void reverseArray(int[] a) {
		for (int i = 0, j = a.length - 1; i <= j; j--, i++) {
			swap(a, i, j);
		}
	}

	static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 9, 1, 2, 7, 6, 1, 5 }, 7, 8));
	}
}
