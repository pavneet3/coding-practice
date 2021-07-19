package prc.st.q;

public class CircularToutr {
	static int tour(int p[], int d[]) {
		int b = 0;
		int n = p.length;
		int i = 0, j = 0;
		boolean im = false;
		while (i < n) {
			im = false;
			b = b + (p[j] - d[j]);
			while (i < n && b < 0) {
				b = b - (p[i] - d[i]);
				i++;
				im = true;
			}
			if (i >= n) {
				return -1;
			}
			j++;
			j = j % n;
			if (!im && i == j) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(tour(new int[] { 55, 52, 33, 100 }, new int[] { 77, 61, 40, 69 }));
	}
}
