package prc.array;

import java.util.ArrayList;

public class StockBuyAndSell {
	static ArrayList<ArrayList<Integer>> stockBuySell(int a[], int n) {
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		int i = 0;
		int j = 1;
		while (j < a.length) {
			if (a[i] <= a[j]) {
				while (j < a.length - 1 && a[j + 1] >= a[j]) {
					j++;
				}

				if (j < a.length) {
					ArrayList<Integer> ar = new ArrayList<Integer>();
					ar.add(i);
					ar.add(j);
					l.add(ar);
					i = j + 1;
					j = i + 1;
				}
			} else {
				i++;
				j++;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println(stockBuySell(new int[] { 4, 2, 2, 2, 4 }, 0));
	}

}
