package lb.matrix;

public class SearchMatric {
	public boolean searchMatrix(int[][] a, int t) {
		int i = 0;
		int j = a[i].length - 1;
		while (i < a.length && j < a[0].length && i >= 0 && j >= 0) {
			if (a[i][j] == t) {
				return true;
			}
			if (a[i][j] > t) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}
