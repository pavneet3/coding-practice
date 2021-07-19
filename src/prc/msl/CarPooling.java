package prc.msl;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
	public static boolean carPooling(int[][] a, int capacity) {
		int c = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int o1[], int o2[]) -> o1[2] - o2[2]);
		Arrays.sort(a, (int[] o1, int o2[]) -> o1[1] - o2[1]);
//		printA(a);
		int i = 0;
		while (i < a.length) {
//			System.out.println(pq.isEmpty() ? "bal" : pq.peek()[2]);
			while (!pq.isEmpty() && pq.peek()[2] <= a[i][1]) {
				int[] v = pq.poll();
				c -= v[0];
			}
			if (a[i][0] > capacity || a[i][0] + c > capacity) {
				return false;
			}
			pq.add(a[i]);
			c += a[i][0];
			i++;
		}
		return true;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static void printA(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));
	}
}
