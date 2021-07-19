package prc.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		boolean vis[] = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		int i = 0;
		q.add(i);
		vis[i] = true;
		while (!q.isEmpty()) {
			int s = q.poll();
			a.add(s);
			for (Integer k : adj.get(s)) {
				if (!vis[k]) {
					vis[k] = true;
					q.add(k);
				}
			}
		}
		return a;
	}
}
