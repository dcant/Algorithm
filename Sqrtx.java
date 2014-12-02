package cn.edu.sjtu.zzang;

public class Sqrtx {
    public int sqrt(int x) {
        if (x < 0)
        	return -1;
        else if (x == 0)
        	return 0;
        else {
        	double y = 1;
        	double lasty = 0;
        	while (y != lasty) {
        		lasty = y;
        		y = (y + x/y)/2;
        	}
        	return (int)y;
        }
    }
}
