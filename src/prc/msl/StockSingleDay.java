package prc.msl;

public class StockSingleDay {
	public int maxProfit(int[] a) {
		int i = 0;
		int j = i + 1;
		int m = 0;

		while (j < a.length) {
			if (a[j] < a[i]) {
				i = j;
				j = i + 1;
			} else {
				m = Math.max(m, a[j] - a[i]);
				j++;
			}
		}
		return m;
	}
}
