package prc.msl;

public class MountainArray {
	public boolean validMountainArray(int[] a) {
		if (a.length < 3) {
			return false;
		}
		boolean up = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (up) {
				if (a[i + 1] <= a[i]) {
					up = false;
				}
			} else {
				if (a[i + 1] > a[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
