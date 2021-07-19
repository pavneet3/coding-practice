package exp.te;

import java.math.BigInteger;

public class SecondLargest {

	static String getSecondMax(String[] elements) {
		if (elements.length == 0) {
			return "-1";
		}
		BigInteger max = new BigInteger(elements[0]);
		BigInteger secondMax = null;
		for (int i = 1; i < elements.length; i++) {
			BigInteger value = new BigInteger(elements[i]);
			BigInteger previousMax = null;
			if (value.compareTo(max) == 1) {
				previousMax = max;
				max = value;
				secondMax = previousMax;
			} else {
				if (secondMax == null) {
					if (value.compareTo(max) == -1) {
						secondMax = value;
					}
				} else {
					if (value.compareTo(secondMax) == 1) {
						secondMax = value;
					}
				}
			}
		}
		return secondMax == null ? "-1" : secondMax.toString();
	}

	public static void main(String[] args) {
		System.out.println(getSecondMax(new String[] { "-214748364801", "-214748364802" }));
	}
}
