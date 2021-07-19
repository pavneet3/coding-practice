
/*
 * 
 * 10
 * 
 * 1,2,3,5,7,11,
 * 4
 * 
 * 
 * 
 * */

public class NPrimeNum {

	static void nPrime(int n) {
		int i = 3;
		if(n!=0) {
			System.out.print(2+" ");
			n--;
		}
		while (n != 0 && i < Integer.MAX_VALUE) {
			if(isPrime(i)) {
				System.out.print(i+" ");
				n--;
			}
			i+=2;
		}
	}

	private static boolean isPrime(int n) {
		for(int i=3;i<=Math.pow(n, 0.5);i+=2) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		nPrime(10);
	}

}
