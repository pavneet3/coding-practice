package prc.maths;

public class PrimeNumber {
	static int isPrime(int n) {
		if (n <= 1) {
			return 0;
		}
		for (int i = 0; i * i <= n; i++) {
			if (n % i == 0) {
				return 0;
			}
		}
		return 1;
	}
}