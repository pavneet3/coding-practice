package prc.dp;

public class MinJumps {
//	static int minJumps(int[] a) {
//		int r[] = new int[a.length];
//		Arrays.fill(r, Integer.MAX_VALUE);
//		r[0] = 0;
//		for (int i = 1; i < a.length; i++) {
//			for (int j = 0; j < i; j++) {
//				if (i <= a[j] + j) {
//					r[i] = Math.min(r[i], r[j] + 1);
//				}
//			}
//		}
//		printA(r);
//		return r[a.length - 1] == Integer.MAX_VALUE ? -1 : r[a.length - 1];
//	}

	static int minJumps(int[] a) {
		if (a[0] == 0) {
			return -1;
		}
		int mx = a[0];
		int st = a[0];
		int j = 1;
		for (int i = 1; i < a.length; i++) {
			if (i == a.length - 1) {
				return j;
			}
			mx = Math.max(mx, a[i] + i);
			st--;
			if (st == 0) {
				j++;
				if (i - mx >= 0) {
					return -1;
				}
				st = mx - i;
			}
		}
		return j;
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println(minJumps(new int[] { 2, 1, 0, 1 }));
	}
}
