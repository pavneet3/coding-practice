
public class TopTal {

	static int numberOfCarryOperations(int a, int b) {
		int totalCarryCount = 0;
		int c = 0;
		while (a != 0 && b != 0) {

			int a1 = a % 10;
			int b1 = b % 10;

			a1 = a1 + c;
			int carry = (a1 + b1) / 10;
			if (carry > 0) {
				totalCarryCount++;
			}
			c = carry;

			a = a / 10;
			b = b / 10;

			if (c != 0) {
				if (a == 0) {
					a = c;
					c = 0;
				} else if (b == 0) {
					b = c;
					c = 0;
				}
			}
		}
		return totalCarryCount;
	}

	public static void main(String[] args) {
		System.out.println(numberOfCarryOperations(29, 55)); // 1
		System.out.println(numberOfCarryOperations(65, 55)); // 2
		System.out.println(numberOfCarryOperations(123, 456)); // 0);
		System.out.println(numberOfCarryOperations(555, 555)); // 3);
		System.out.println(numberOfCarryOperations(900, 11)); // 0);
		System.out.println(numberOfCarryOperations(145, 55)); // 2);
		System.out.println(numberOfCarryOperations(0, 0)); // 0);
		System.out.println(numberOfCarryOperations(1, 99999)); // 5);
		System.out.println(numberOfCarryOperations(999045, 1055)); // 5);
		System.out.println(numberOfCarryOperations(101, 809)); // 1);
		System.out.println(numberOfCarryOperations(189, 209)); // 1);
	}
}
