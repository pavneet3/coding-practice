package prc.msl;

import java.util.Arrays;

public class MIS01 {
	static int mis(int a[]) {
		int r[] = new int[a.length];
		int m = 1;
		Arrays.fill(r, 1);
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((a[j] == a[i] || Math.abs(a[j] - a[i]) == 1) && r[j] >= r[i]) {
					r[i] = Math.max(r[j], r[i]) + 1;
					m = Math.max(m, r[i]);
				}
			}
			System.out.print("i : " + i+"-");
			printA(r);
		}
		printA(r);
		return m;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println(mis(new int[] { -2, -1, 5, -1, 4, 0, 3 }));
	}

}
