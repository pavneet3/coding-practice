package leetcode.june;

import java.util.HashMap;
import java.util.Map.Entry;

//  0,3,7,2,5,8,4,6,0,1 // 
//  m=1
/*
 *0->1
 *3 - 4
 *7 - 8
 *2 - 3 
 *5 - 6
 * 
 * 
 * */

public class LongestConsecutiveElements {
	public static int longestConsecutive(int[] a) {}

	private static void populateMap(HashMap<Integer, Integer> s, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (s.get(a[i]) == -1) {
				populatMapForValue(a[i], s);
			}
		}
	}

	private static int populatMapForValue(int v, HashMap<Integer, Integer> s) {
		if (!s.containsKey(v)) {
			return 0;
		}
		if (v == Integer.MIN_VALUE) {
			s.put(v, 1);
			return 1;
		}
		if (s.get(v) != -1) {
			return s.get(v);
		}
		int mv = 1 + populatMapForValue(v - 1, s);
		s.put(v, mv);
		return mv;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
