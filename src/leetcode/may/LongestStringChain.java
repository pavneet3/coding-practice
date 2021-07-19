package leetcode.may;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
	public static int longestStrChain(String[] s) {
		int r[] = new int[s.length];
		int m = 0;
		Arrays.fill(r, 1);
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		printS(s);
		for (int i = 1; i < s.length; i++) {
			for (int j = 0; j < i; j++) {
				if (s[i].length() - s[j].length() == 1 && isOneCharDiff(s[i], s[j])) {
					r[i] = Math.max(r[i], r[j] + 1);
					m = Math.max(m, r[i]);
				}
			}
		}
		printA(r);
		return m;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static void printS(String a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static boolean isOneCharDiff(String s2, String s1) {
		int d = 0;
		for (int i = 0, j = 0; i < s1.length(); j++) {
			if (s1.charAt(i) != s2.charAt(j)) {
				d++;
				if (d > 1) {
					return false;
				}
			} else {
				i++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[] { "a", "b", "ab", "bac" }));
	}
}
