package cn.edu.sjtu.zzang;

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("1"));
	}

	public int numDecodings(String s) {  
        if (s.length()==0||s==null||s=="0") 
            return 0; 

        int[] dp = new int[3];  
        dp[0] = 1;  
        
        if (isValid(s.substring(0,1)))
            dp[1] = 1;  
        else 
            dp[1] = 0;
        int i = 2;
        for(; i<=s.length();i++){
        	dp[i%3] = 0;
            if (isValid(s.substring(i-1,i)))  
                dp[i % 3] += dp[(i-1)%3];
            if (isValid(s.substring(i-2,i)))
                dp[i % 3] += dp[(i-2)%3];
        }
        return dp[(i - 1)%3];  
    }  
      
    public boolean isValid(String s){  
        if (s.charAt(0)=='0') 
            return false;  
        int code = Integer.parseInt(s);  
        return code>=1 && code<=26;  
    }
}
