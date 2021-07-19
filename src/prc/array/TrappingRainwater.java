package prc.array;

public class TrappingRainwater {
	static int trappingWater(int a[], int n) {
		int t = 0;
		int ts = 0;
		int i = 0;
		int j = 1;
		while (j < a.length) {
			if (a[j] < a[i]) {
				ts += a[j];
				j++;
			} else {
				t += (a[i] * (j - i - 1)) - ts;
				ts = 0;
				i = j;
				j++;
			}
		}
		ts = 0;
		j = a.length - 2;
		int k = a.length - 1;
		while (j >= i) {
			if (a[j] < a[k]) {
				ts += a[j];
				j--;
			} else {
				t += (a[k] * (k - j - 1)) - ts;
				ts = 0;
				k = j;
				j--;
			}
		}
		return t;
	}

	public static void main(String[] args) {
		int a[] = new int[] { 3, 3, 3, 0, 2, 0, 1, 0, 0 };
		System.out.println(trappingWater(a, a.length));
	}
}
