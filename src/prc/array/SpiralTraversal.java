package prc.array;

import java.util.ArrayList;

public class SpiralTraversal {
	static ArrayList<Integer> spirallyTraverse(int a[][], int r, int c) {
		int t = 0;
		int b = r - 1;
		int l = 0;
		int rt = c - 1;
		int v = 0;
		ArrayList<Integer> lst = new ArrayList<Integer>();
		while (t <= b && l <= rt) {
			if (v == 0) {
				for (int i = l; i <= rt; i++) {
					lst.add(a[t][i]);
				}
				t++;
			} else if (v == 1) {
				for (int i = t; i <= b; i++) {
					lst.add(a[i][rt]);
				}
				rt--;
			} else if (v == 2) {
				for (int i = rt; i >= l; i--) {
					lst.add(a[b][i]);
				}
				b--;
			} else if (v == 3) {
				for (int i = b; i >= t; i--) {
					lst.add(a[i][l]);
				}
				l++;
			}
			v = (v + 1) % 4;
		}
		return lst;
	}

	public static void main(String[] args) {
		System.out.println(spirallyTraverse(
				new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } }, 2, 4));
	}
}
