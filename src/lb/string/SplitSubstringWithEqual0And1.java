package lb.string;

/*
 * 00110011
 * 
 * */
public class SplitSubstringWithEqual0And1 {
	public static int countBinarySubstrings(String s) {
		int i = 0; // 1
		int r = 0;
		int c1 = 1; // 2
		while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
			i++;
			c1++;
		}
		if (i >= s.length() - 1) {
			return r;
		}
		i = 0;
		while (i < s.length() - 1) {
			int c2 = 1;
			int m = i + c1;
			if (m >= s.length()) {
				i = i + c1;
				continue;
			}
			while (m < s.length() - 1 && s.charAt(m) == s.charAt(m + 1)) {
				m++;
				c2++;
			}
			r += Math.min(c1, c2);
			i = i + c1;
			c1 = c2;
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("00001111111101"));
	}
}
