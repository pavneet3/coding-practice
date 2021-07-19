package leetcode.june;

public class LongestOnes {
	public static int longestOnes(int[] a, int k) {
		int m = 0;
		int c = 0;
		int j = 0;
		int i = 0;
		while (j < a.length) {
			if (a[j] == 0) {
				if (k == 0) {
					while (a[i] != 0 && i <= j) {
						i++;
						c--;
					}
					i++;
					c--;
					k++;
				} else {
					j++;
					c++;
					k--;
				}
			} else {
				j++;
				c++;
			}
			m = Math.max(c, m);
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
	}

}
