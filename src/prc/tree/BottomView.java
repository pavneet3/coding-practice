package prc.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BottomView {
	public ArrayList<Integer> bottomView(Node root) {
		Map<Integer, List<Integer>> ar = new HashMap<>();
		populateVerticalView(ar, root, 0);
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (Entry<Integer, List<Integer>> e : ar.entrySet()) {
			r.add(e.getValue().get(0));
		}
		return r;
	}

	private void populateVerticalView(Map<Integer, List<Integer>> ar, Node root, int l) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			populateVerticalView(ar, root.left, l - 1);
		}
		if (root.right != null) {
			populateVerticalView(ar, root.right, l + 1);
		}
		List<Integer> g = ar.getOrDefault(l, new ArrayList<Integer>());
		g.add(root.data);
		ar.put(l, g);
	}
}
