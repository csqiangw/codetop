public class _49_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;//nums[i]的值已经变了，要用原来的
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i)
                return i + 1;
        }
        return nums.length + 1;
    }

}
