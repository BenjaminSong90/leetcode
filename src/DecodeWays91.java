public class DecodeWays91 {
    public static void main(String[] a) {
        System.out.println(new DecodeWays91().numDecodings("222202"));
    }


    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        int pre = s.charAt(0) - '0';
        if(pre == 0) return 0;
        dp[0] = 1;
        for(int i=1; i<s.length(); i++){
            int cur = s.charAt(i) - '0';
            if(cur==0){

                if(pre==0 || pre>2) break;

                if(i>1) dp[i] = dp[i-2];
                else dp[i] = 1;
            }
            else{
                if(pre!=0 && pre*10+cur<=26){

                    if(i>1) dp[i] = dp[i-1]+dp[i-2];
                    else dp[i] = dp[i-1] + 1;
                }
                else dp[i] = dp[i-1];
            }

            pre = cur;
        }

        return dp[s.length()-1];

    }






}
