package lb.array;

public class BuySellStock {
	public int maxProfit(int[] a) {
		int mn = 0;
		int i = 0;
		int p = 0;
		while (i < a.length) {
			if (a[i] <= a[mn]) {
				mn = i;
			} else {
				p = Math.max(a[i] - a[mn], p);
			}
			i++;
		}
		return p;
	}
}
