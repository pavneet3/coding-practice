package lb.array;

public class DuplicateNumber {
	public int findDuplicate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int v = Math.abs(a[i]);
			if (a[v] < 0) {
				return i;
			}
			a[v] = -a[v];
		}
		return -1;
	}
}
