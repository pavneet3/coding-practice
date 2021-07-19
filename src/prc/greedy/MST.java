package prc.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MST {
	static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> a) {
		System.out.println(a);
		int wt[] = new int[v];
		Arrays.fill(wt, Integer.MAX_VALUE);
		wt[0] = 0;
		int c = 0;
		HashSet<Integer> st = new HashSet<>();
		while (st.size() != v) {
			int mn = Integer.MAX_VALUE;
			int val = 0;
			for (int i = 0; i < v; i++) {
				if (!st.contains(wt[i])) {
					if (wt[i] < mn) {
						mn = wt[i];
						val = i;
					}
				}
			}
			st.add(val);
			c += wt[val];
			for (int i = 0; i < a.get(val).get(0).size(); i++) {
				int value = a.get(val).get(1).get(i);
				int w = a.get(val).get(0).get(i);
				if (!st.contains(value)) {
					wt[value] = Math.min(wt[value], w);
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<ArrayList<Integer>>> a = new ArrayList<>();
		ArrayList<ArrayList<Integer>> v0 = new ArrayList<>();
		v0.add(new ArrayList<Integer>(Arrays.asList(5, 3)));
		v0.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
		a.add(v0);
		ArrayList<ArrayList<Integer>> v1 = new ArrayList<>();
		v1.add(new ArrayList<Integer>(Arrays.asList(5, 1)));
		v1.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
		a.add(v1);
		ArrayList<ArrayList<Integer>> v2 = new ArrayList<>();
		v2.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
		v2.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
		a.add(v2);
		System.out.println(spanningTree(3, a));
	}

}
