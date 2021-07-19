package prc.array;

public class RotatedSortedDuplicate {
	public boolean search(int[] a, int t) {
		int n = a.length - 1;
		int s = 0;
		while (s <= n) {
			int m = (s+n)/2;
			if(a[m] == t) {
				return true;
			}else if(a[n] > t) {
				
			}else {
				
			}
		}
	}
}
