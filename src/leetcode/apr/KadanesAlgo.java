package leetcode.apr;

public class KadanesAlgo {
	static int maxSubarraySum(int a[], int n) {
		if (n == 0) {
			return 0;
		}
		int m = a[0];
		int cm = a[0];
		for (int i = 1; i < a.length; i++) {
			cm = Math.max(a[i], cm + a[i]);
			m = Math.max(cm, m);
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(maxSubarraySum(new int[] { -1, -2, -3, -4 }, 4));
	}
}
