package prc.dp;

public class CountCommonSubSequence {

	static int count(String s1, String s2, int m, int n) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + count(s1, s2, m - 1, n - 1);
		} else {
			return count(s1, s2, m - 1, n) + count(s1, s2, m, n - 1) +1;
		}
	}

	public static void main(String[] args) {
		System.out.println(count("abc", "abc", 3, 3));
	}

}
