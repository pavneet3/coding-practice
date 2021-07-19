import java.util.LinkedList;

class Cell {
	int i;
	int j;
	int t;

	Cell(int i, int j, int t) {
		this.i = i;
		this.j = j;
		this.t = t;
	}
}

public class RottonMangos {

	int timeRottonManogos(int a[][]) {
		int r = 0;
		LinkedList<Cell> q = new LinkedList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 2) {
					populateQueue(i, j, a, q, 0);
				}
			}
			while (!q.isEmpty()) {
				Cell v = q.poll();
				a[v.i][v.j] = 2;
				r = v.t;
				populateQueue(v.i, v.j, a, q, v.t);
			}
		}
		return r;
	}

	private void populateQueue(int i, int j, int[][] a, LinkedList<Cell> q, int t) {
		if (i > 0 && a[i - 1][j] == 1) {
			q.add(new Cell(i - 1, j, t + 1));
		}
		if (j > 0 && a[i][j - 1] == 1) {
			q.add(new Cell(i, j - 1, t + 1));
		}
		if (j < a[0].length - 1 && a[i][j + 1] == 1) {
			q.add(new Cell(i, j + 1, t + 1));
		}
		if (i < a.length - 1 && a[i + 1][j] == 1) {
			q.add(new Cell(i + 1, j, t + 1));
		}
	}

}
