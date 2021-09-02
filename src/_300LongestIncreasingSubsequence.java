import java.util.Arrays;

public class _300LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println("Result>>>>>>"+ new _300LongestIncreasingSubsequence().lengthOfLIS(nums));
    }


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int res = 0;
        for(int n: dp){
            res = Math.max(res, n);
        }

        return res;

    }
}
