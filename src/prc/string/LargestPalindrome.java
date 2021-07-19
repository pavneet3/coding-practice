package prc.string;

public class LargestPalindrome {
	 public static String longestPalindrome(String s) {
		int m = 0;
		String rs = "";
		for (int i = 0; i < s.length(); i++) {
			String a = getMaxLengthOfPalindrome(s, i);
//			System.out.println("for i : " + i + " a is : " + a);
			if (a.length() > m) {
				m = a.length();
				rs = a;
			}
		}
		return rs;
	}

	private static String getMaxLengthOfPalindrome(String s, int i) {
		int m = 0;
		int k = i - 1;
		int j = i;
		int l = i + 1;
		int l1 = i + 1;
		while (k >= 0 && l < s.length()) {
			if (s.charAt(k) == s.charAt(l)) {
				l++;
				k--;
			} else {
				break;
			}
		}
		m = Math.max(m, l - k - 1);
		while (j >= 0 && l1 < s.length()) {
			if (s.charAt(j) == s.charAt(l1)) {
				l1++;
				j--;
			} else {
				break;
			}
		}
		if (m < l1 - j - 1) {
			return s.substring(j + 1, l1);
		} else {
			return s.substring(k + 1, l);
		}
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abc"));
	}
}
