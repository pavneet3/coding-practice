package prc.dp;

import java.util.Arrays;
import java.util.Comparator;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

}

class CompareByFirst implements Comparator<Pair> {
	public int compare(Pair a, Pair b) {
		return a.x - b.x;
	}

}

public class MaxLengthChain {
	static void printA(Pair a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static int maxChainLength(Pair a[], int n) {
		Arrays.sort(a, new CompareByFirst());
		int b[] = new int[a.length];
		Arrays.fill(b, 1);
		int m = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j].y > a[i].x && b[i] <= b[j]) {
					b[i] = b[j] + 1;
					m = Math.max(m, b[i]);
				}
			}
		}
		return m;
	}

	public static void main(String[] args) {
//		int m = maxChainLength(
//				new Pair[] { new Pair(5, 24), new Pair(39, 60), new Pair(15, 28), new Pair(27, 40), new Pair(50, 90) },
//				1);
		int m = maxChainLength(new Pair[] { new Pair(5, 10), new Pair(1, 11) }, 1);
		System.out.println(m);
	}
}
