
/*
 * 
 * 
0 0 0 1
0 0 1 1
0 0 0 0 
0 1 1 1
0 0 1 1
 * 
 * 
 * 
 * */

/*
 * 
 * 
 * -2, -3, 4, -1, -2, 1, 5, -3
 * 
 * 
 * c = 7
 * m = 7
 * 
 * 
 * */
public class Max1InMat {

	static int max1(int a[][]) {
		int mi = 0; // 3
		int i = 0, j = a[0].length - 1; // 5,1
		while (j >= 0 && i < a.length) {
			if (a[i][j] == 1) {
				mi = i;
			}
			if (j > 0) {
				if (a[i][j - 1] == 1) {
					j--;
				} else {
					i++;
				}
			} else {
				i++;
			}
		}
		return mi;
	}

	static int maxSubArray(int a[]) {
		if (a.length == 0) {
			return -1;
		}
		int m = a[0];
		int c = a[0];
		for (int i = 1; i < a.length; i++) {
			c = Math.max(c + a[i], a[i]);
			m = Math.max(c, m);
		}
		return m;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -1, -3, -10, -34 }));
	}
}
