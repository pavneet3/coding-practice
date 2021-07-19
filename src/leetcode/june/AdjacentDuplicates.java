package leetcode.june;

/*
 * baabbbc
 * 
 * 
 * */
public class AdjacentDuplicates {
	public static String removeDuplicates(String s) {
		int i = -1; // 0
		int j = 0; // 2
		StringBuilder sb = new StringBuilder(s);
		while (j < sb.length() - 1) {
			if (sb.charAt(j) == sb.charAt(j + 1)) {
				j++;
				sb = sb.replace(i + 1, j + 1, "");
				if (i != -1) {
					j = i;
					i = i - 1;
				} else {
					j = 0;
				}
			} else {
				j++;
				i++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
	}

}
