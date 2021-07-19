package prc.dp;

public class MinOpr {
	public int minOperation(int n) {
		int c = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				n--;
			} else {
				n = n / 2;
			}
			c++;
		}
		return c;
	}
}
