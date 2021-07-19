package tst.khabri;

import java.util.LinkedHashMap;

public class FirstNonRepeatingInStream {

	static void nonRepeatingInStream(char a[]) {
		LinkedHashMap<Character, Integer> m = new LinkedHashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (m.containsKey(a[i])) {
				m.remove(a[i]);
			} else {
				m.put(a[i], null);
			}
			char r = '\t';
			for (Character k : m.keySet()) {
				r = k;
				break;
			}
			System.out.print(r == '\t' ? -1 : r + " ");
		}
	}

	public static void main(String[] args) {
		nonRepeatingInStream(new char[] { 'a', 'a', 'b', 'c', 'b' });
	}

}
