package prc.maths;

public class pow {
	long power(int n, int r) {
		if (n == 0) {
			return 0;
		}
		if (r == 0) {
			return 1;
		}
		long t = power(n, r / 2);
		if (r % 2 == 0) {
			return t * t;
		} else {
			if (r > 0)
				return n * t * t;
			else
				return (t * t) / n;
		}
	}
}
