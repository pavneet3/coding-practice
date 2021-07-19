package prc.greedy;

public class LargestNumberPossible {
	static String findLargest(int n, int s) {
		int ms = n * 9;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(9);
		}
		int d = ms - s;
		int i = sb.length() - 1;
		while (d > 0) {
			int sv = Math.min(d, 9);
			sb.replace(i, i + 1, "" + (Integer.parseInt("" + sb.charAt(i)) - sv));
			d -= sv;
			i--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
	}
}
