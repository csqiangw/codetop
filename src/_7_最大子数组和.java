public class _7_最大子数组和 {

    /**
     * dp[i]代表的意思是0 - i的最大子序列和
     * 首先要注意，不要盲目赋值为0，因为它们的最大子序列和很可能就是一个负值
     * 当每次判断时，只要判断前一个状态是否小于0，若小于0，它只会把当前状态变得更小，所以不能加上
     * 若前一个状态大于等于0，它对当前状态只有增益或无效，那么可以得到最大子
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

}
