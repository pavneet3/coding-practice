package prc.tree;

public class Test {

	static boolean func(int a) {
		if (a <= 1) {
			return false;
		}
		if (a == 2) {
			return true;
		}
		if (a % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(a); i += 2) {
			System.out.println("i " + i);
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	
	
	
	public static void main(String[] args) {
		func(101);
	}

}
