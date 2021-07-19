package leetcode.june;

public class MaxConsecutiveOnes {
	public static int findMaxConsecutiveOnes(int[] a) {
		int i = 0;
		int j = 0;
		int m = 0;
		while (j < a.length) {
			while (j < a.length && a[j] == 1) {
				j++;
			}
			m = Math.max(j - i, m);
			while (j < a.length && a[j] == 0) {
				j++;
			}
			i = j;
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 }));
	}
}
