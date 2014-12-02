package cn.edu.sjtu.zzang;

public class PowerXN {
	public static void main(String[] args) {
		PowerXN pxn = new PowerXN();
		System.out.println(pxn.pow(2, 3));
		System.out.println(pxn.pow(-2, 3));
		System.out.println(pxn.pow(2, -3));
		System.out.println(pxn.pow(-2, -3));
		System.out.println(pxn.pow(4.70975, -6));
	}

    public double pow(double x, int n) {
    	if (n < 0)
    		return 1 / worker(x, -n);
    	else
    		return worker(x, -n);
    }
    private double worker(double x, int n) {
    	if (n == 0)
    		return 1;
    	double tmp = worker(x, n / 2);
    	if (n % 2 == 0)
    		return tmp * tmp;
    	else 
    		return tmp * tmp * x;
    }
}
