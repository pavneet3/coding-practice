package leetcode.apr;

public class PowerOf3 {
	public static boolean isPowerOfThree(int n) {
		if ((log3(n) % 1.0) + 0.1 <= 2 * 0.1) {
			return true;
		}
		return false;
	}

	static double log3(int x) {
		return Math.log(x) / Math.log(3);
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(243));
		System.out.println(log3(243));
	}
}
