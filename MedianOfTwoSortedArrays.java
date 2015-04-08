package cn.edu.sjtu.zzang;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays mot = new MedianOfTwoSortedArrays();
		int[] A = {1,6};
		int[] B = {2,3,4,5,7,8,9,10};
		System.out.println(mot.findMedianSortedArrays(A, B));
	}
	
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 1)
            return fmsaWorker(A, B, (A.length + B.length)/2, 0, A.length - 1, 0, B.length - 1);
        else
            return (fmsaWorker(A, B, (A.length + B.length)/2, 0, A.length - 1, 0, B.length - 1) +
            fmsaWorker(A, B, (A.length + B.length)/2 - 1, 0, A.length - 1, 0, B.length - 1)) * 0.5;
    }
    
    public double fmsaWorker(int[] a, int[] b, int k, int ol, int oh, int tl, int th) {
        int olen = oh - ol + 1;
        int tlen = th - tl + 1;
        if (olen == 0)
            return b[tl + k];
        if (tlen == 0)
            return a[ol + k];
        if (k == 0)
            return a[ol] < b[tl] ? a[ol] : b[tl];
        int oindx = olen * k / (olen + tlen);
        int tindx = k - oindx - 1;
        oindx += ol;
        tindx += tl;
        if (a[oindx] == b[tindx])
            return a[oindx];
        else if (a[oindx] < b[tindx]) {
            k = k - (oindx - ol + 1);
            ol = oindx + 1;
            th = tindx;
        } else {
            k = k - (tindx - tl + 1);
            tl = tindx + 1;
            oh = oindx;
        }
        return fmsaWorker(a, b, k, ol, oh, tl, th);
    }
}
