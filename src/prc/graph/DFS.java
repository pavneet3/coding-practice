package prc.graph;

import java.util.ArrayList;

public class DFS {
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		boolean vis[] = new boolean[V];
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				dfs(adj, i, vis, a);
			}
		}
		return a;
	}

	private void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, ArrayList<Integer> a) {
		a.add(i);
		vis[i] = true;
		ArrayList<Integer> l = adj.get(i);
		for (Integer k : l) {
			if(!vis[k]) {
				dfs(adj, k, vis, a);				
			}
		}
	}
}
