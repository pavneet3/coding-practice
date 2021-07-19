package prc.msl;

public class ReachANumber {
	public int reachNumber(int t) {
		t = Math.abs(t);
		int step = 0;
		int sum = 0;
		while (sum < t || (sum - t) % 2 != 0) {
			sum += step;
			step++;
		}
		return step;
	}
}
