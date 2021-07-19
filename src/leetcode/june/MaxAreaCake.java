package leetcode.june;

import java.util.Arrays;

public class MaxAreaCake {
//	public static int maxArea(int h, int w, int[] hc, int[] vc) {
//		final int M = (int) Math.pow(10, 9) + 7;
//		boolean hb[] = new boolean[h + 1];
//		boolean vb[] = new boolean[w + 1];
//		hb[0] = true;
//		hb[hb.length - 1] = true;
//		for (int i = 0; i < hc.length; i++) {
//			hb[hc[i]] = true;
//		}
//		vb[0] = true;
//		vb[vb.length - 1] = true;
//		for (int i = 0; i < vc.length; i++) {
//			vb[vc[i]] = true;
//		}
//
//		int mxh = 1;
//		int mxv = 1;
//		int c = 1;
//		for (int i = 0; i < hb.length; i++) {
//			if (hb[i]) {
//				c = 1;
//			} else {
//				c++;
//			}
//			mxh = Math.max(c, mxh);
//		}
//		c = 1;
//		for (int i = 0; i < vb.length; i++) {
//			if (vb[i]) {
//				c = 1;
//			} else {
//				c++;
//			}
//			mxv = Math.max(c, mxv);
//		}
//		return (mxv * mxh) % M;
//	}

	public static int maxArea(int h, int w, int[] hc, int[] vc) {
		Arrays.sort(hc);
		Arrays.sort(vc);
		int mxh = hc.length == 0 ? h : hc[0] - 0;
		int mxv = vc.length == 0 ? w : vc[0] - 0;
		for (int i = 0; i < hc.length - 1; i++) {
			mxh = Math.max(mxh, hc[i + 1] - hc[i]);
		}
		for (int i = 0; i < vc.length - 1; i++) {
			mxv = Math.max(mxv, vc[i + 1] - vc[i]);
		}
		mxh = Math.max(mxh, hc.length == 0 ? mxh : h - hc[hc.length - 1]);
		mxv = Math.max(mxv, vc.length == 0 ? mxv : w - vc[vc.length - 1]);
		return mxv * mxh;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(5, 4, new int[] { 3 }, new int[] { 1 }));
	}
}
