package prc.array;

public class KadanesALgo {

	public static int maxSum(int a[]) {
		int c = a[0];
		int m = a[0];
		for (int i = 1; i < a.length; i++) {
			c = Math.max(a[i], c + a[i]);
			m = Math.max(c, m);
		}
		return m;
	}
	
	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSum(a));
	}

}
