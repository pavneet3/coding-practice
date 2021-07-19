
/*
 * n=4
 * p [4,6,7,4]
 * d [6,5,3,5]
 * 
 * start=1
 * end=2
 * b=5
 * 
 * */

public class CircularPath {

	int curcularPath(int p[], int d[]) {
		int start = 0;
		int end = 0; 
		int bal = 0; 
		while (start < d.length) {
			bal = bal + (p[end] - d[end]);
			end = (end + 1) % d.length;
			if (bal < 0) {
				while (start < d.length && bal < 0) {
					bal = bal - (p[start] - d[start]);
					start++;
				}
			} else {
				if (start == end) {
					return start;
				}
			}
		}
		return -1;
	}

}
