/**
 * 题目解析（竖着求）：
 * 双指针往中间夹（考虑有水）：
 * 若左边最大值比右边最大值小，那么思考一下，我的最高上限只能是左边最大值，而右边最大值比左边大，那么它一定能兜住
 * 此时不用考虑中间什么情况，因为就算有更大的，那么我也只能以目前左边最大值为上限，若有更小的，它比我小，也比右边最大的小，所以没有意义
 * 右边同理
 * 此外，为什么，右边更小时，求右边的，不接着求左边的？
 * 因为右边的max更小时，左边一定能兜住，若求左边的，此时以右边小的为标准，若中间出现一个更高的时，那么就出现了不准确
 * 而哪边求哪边的，就没有这种情况发生
 */
public class _29_接雨水 {

    public int trap(int[] height) {
        int left_max = height[0],right_max = height[height.length - 1];
        int left = 1,right = height.length - 2;
        int ret = 0;
        while(left <= right){
            if(left_max < right_max){
                if(left_max > height[left])
                    ret += left_max - height[left];
                left_max = Math.max(height[left],left_max);
                left++;
            }else{
                if(right_max > height[right])
                    ret += right_max - height[right];
                right_max = Math.max(height[right],right_max);
                right--;
            }
        }
        return ret;
    }

}
