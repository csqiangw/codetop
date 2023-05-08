/**
 * 动态规划，不需要考虑序列是否连续，只要考虑递增
 * dp[i]代表截止到i，最长的递增子序列
 * 所以求解的时候只要向前找，找到自己比nums[j]大，再看看加上自己本身这个1是否长度更大即可
 * 最后就是遍历数组，看看截止到哪个是最大
 */
public class _28_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if(max < dp[i])
                max = dp[i];
        }
        return max;
    }

}
