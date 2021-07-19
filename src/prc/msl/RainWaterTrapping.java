package prc.msl;

public class RainWaterTrapping {
	public static int trap(int[] a) {
		int i = 0;
		for (; i < a.length - 1; i++) {
			if (a[i + 1] < a[i]) {
				break;
			}
			System.out.println("a");
		}
		if (i == a.length - 1) {
			return 0;
		}
		int mx = i;
		i++;
		int w = 0;
		while (i < a.length) {
			int t = 0;
			while (i < a.length && a[mx] > a[i]) {
				t = t + (a[mx] - a[i]);
				i++;
			}
			if (i < a.length) {
				w = w + t;
				mx = i;
			}
			System.out.println("c");
		}
		// [0,1,0,2,1,0,1,3,2,1,2,1]
		// i
		if (mx < a.length) {
			for (i = a.length - 1; i > mx - 1; i--) {
				if (a[i - 1] < a[i]) {
					break;
				}
				System.out.println("b");
			}
			int j = i;
			i--;
			while (i > mx) {
				int t = 0;
				while (i > mx && a[j] > a[i]) {
					t = t + (a[j] - a[i]);
					i--;
				}
				if (i > mx) {
					w = w + t;
					j = i;
				}
			}
		}
		return w;
	}

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}
