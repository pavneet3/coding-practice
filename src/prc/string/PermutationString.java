package prc.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationString {
	public static List<String> find_permutation(String S) {
		List<String> l = new ArrayList<String>();
		permutate(l, S, 0, S.length() - 1);
		Collections.sort(l);
		return l;
	}

	private static void permutate(List<String> l, String str, int s, int e) {
		if (s == e) {
			l.add(str);
		}
		for (int i = s; i <= e; i++) {
			permutate(l, swap(str, s, i), s + 1, e);
		}
	}

	private static String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		char t = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, t);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(find_permutation("BA"));
	}
}
