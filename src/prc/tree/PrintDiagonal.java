package prc.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintDiagonal {
	public ArrayList<Integer> diagonal(TreeNode root) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		Map<Integer, List<Integer>> m = new HashMap<>();
		populateDiagonal(root, m, 0);
		m.entrySet().stream().forEach(e -> ar.addAll(e.getValue()));
		return ar;
	}

	private void populateDiagonal(TreeNode root, Map<Integer, List<Integer>> m, int d) {
		if (root == null) {
			return;
		}
		List<Integer> ar = m.getOrDefault(d, new ArrayList<>());
		ar.add(root.val);
		m.put(d, ar);
		populateDiagonal(root.left, m, d + 1);
		populateDiagonal(root.right, m, d);
	}
}
