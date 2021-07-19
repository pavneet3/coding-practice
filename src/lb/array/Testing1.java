package lb.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 1->a,b
 * 2->c,d
 * 3->e,f
 * 4->g,h
 * 5->i,j
 * 
 * 123
 * 
 * */

public class Testing1 {

	static Map<Integer, List<String>> m = new HashMap<>();
	static {
		m.put(1, Arrays.asList("a", "b","x"));
		m.put(2, Arrays.asList("c", "d"));
		m.put(3, Arrays.asList("e", "f"));
	}

	static List<String> dfs(int a[]) {
		List<String> list = new ArrayList<String>();
		populateListWithPatterns(list, a, "", 0);
		return list;
	}

	/*
	 * 12
	 * 
	 * s =
	 * 
	 */

	private static void populateListWithPatterns(List<String> list, int[] a, String s, int n) {
		if (n == a.length) {
			if (!s.equals("")) {
				list.add(s);
			}
			return;
		}
		for (int i = 0; i < m.get(a[n]).size(); i++) {
			populateListWithPatterns(list, a, s + m.get(a[n]).get(i), n + 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(dfs(new int[] {1,2,3}));
	}
}
