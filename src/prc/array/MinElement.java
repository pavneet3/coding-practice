package prc.array;

public class MinElement {
	public int findElement(int a[], int n) {
		int b[] = new int[n];
		b[0] = Integer.MIN_VALUE;
		for (int i = 1; i < a.length; i++) {
			b[i] = Math.max(b[i - 1], a[i - 1]);
		}
		int rm = Integer.MAX_VALUE;
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i - 1] < rm && a[i - 1] > b[i]) {
				return i;
			} else {
				rm = Math.min(a[i], rm);
			}
		}
		return -1;
	}
}
