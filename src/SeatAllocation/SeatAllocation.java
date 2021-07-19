package SeatAllocation;

public class SeatAllocation {
	int a[] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	int assign_table() {

		if (treeSet.isEmpty()) {
			a[0] = 1;
			treeSet.add(0);
		} else if (treeSet.size() == 1) {
			int d1 = a.length - treeSet.get(0);
			int d2 = treeSet.get(0) - 0;
			if (d2 >= d1) {
				a[0] = 1;
				treeSet.add(0);
			} else {
				a[a.length - 1] = 1;
				treeSet.add(a.length - 1);
			}
		} else {

			int d = 0;
			int ri = -1;
			for (int i = 0; i < treeSet.size() - 1; i++) {
				Table t = new Table(0, -1);
				int m = (treeSet.get(i + 1) + treeSet.get(i)) / 2;
				t.d = m - treeSet.get(i);
				t.ri = m;
				if (d < t.d) {
					d = t.d;
					ri = t.ri;
				}
			}
			a[ri] = 1;
			treeSet.add(ri);
		}

	}

	void vacate_table(int table_num) {

		a[table_num - 1] = 0;
		treeSet.remove(table_num - 1);

	}
}
