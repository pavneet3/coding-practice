package leetcode.june;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
	public static int openLock(String[] d, String target) {
		Queue<String> q = new LinkedList<>();
		String l = "0000";
		q.add(l);
		int c = 0;
		HashSet<String> de = new HashSet<String>(Arrays.asList(d));
		HashSet<String> vis = new HashSet<String>();
		vis.add(l);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				l = q.poll();
				if (de.contains(l)) {
					size--;
					continue;
				}
				if (l.equals(target)) {
					return c;
				}
				for (int i = 0; i < 4; i++) {
					char cc = l.charAt(i);
					String s1 = l.substring(0, i) + (cc == '9' ? 0 : cc - '0' + 1) + l.substring(i + 1);
					String s2 = l.substring(0, i) + (cc == '0' ? 9 : cc - '0' - 1) + l.substring(i + 1);
					if (!vis.contains(s1)) {
						q.add(s1);
						vis.add(s1);
					}
					if (!vis.contains(s2)) {
						q.add(s2);
						vis.add(s2);
					}
				}
				size--;
			}
			c++;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(openLock(new String[] { "0000" }, "8888"));
	}
}
