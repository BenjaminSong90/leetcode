import java.util.Arrays;

public class _1312MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>"+new _1312MinimumInsertionStepsToMakeAStringPalindrome().minInsertions("zjveiiwvc"));
    }

//    public int minInsertions(String s) {
//        int[][] dp = new int[s.length()][s.length()];
//        return dp(s,dp, 0, s.length()-1);
//    }
//
//    private int dp(String s, int[][] dp,int left, int right){
//        if(left >= right) return 0;
//        if(s.charAt(left) == s.charAt(right)){
//            if (dp[left][right] == 0) {
//                dp[left][right] = dp(s, dp, left + 1, right - 1);
//            }
//            return dp[left][right];
//        } else {
//            int lp = dp[left+1][right];
//            if(lp == 0){
//                lp = dp(s, dp, left+1, right);
//                dp[left+1][right] = lp;
//            }
//
//            int rm = dp[left][right-1];
//            if(rm == 0){
//                rm = dp(s, dp, left, right-1);
//                dp[left][right-1] = rm;
//            }
//            return Math.min(lp, rm)+1;
//        }
//    }


    public int minInsertions(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];

        for(int i = size -2; i >= 0; i--){
            for(int j = i + 1; j < size; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
                }
            }
        }
        return dp[0][size-1];
    }

}
