import java.util.Arrays;

/**
 * 思考给定 2 4 3 1，如何利用这四个数字找一个更大的，很明显得是后面得431已经无法增大了，只能增大2，那么要从431中挑一个小的，但是同时要比2大
 * 所以挑3，接着3 4 2 1，但很明显不符合需求，因为要把后面三位变成小的，那么就应该再从小到大排序，而若是4321，此时就不会有比其大的了，所以
 * 我们在小的之中换完之后，要退出函数，若没退出就说明是4321的情况，最后直接进行排序即可。
 */
public class _44_下一个排列 {

    public void nextPermutation(int[] nums) {
        int min,minIndex = 0,temp;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]){
                min = Integer.MAX_VALUE;
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if(nums[j] < min && nums[j] > nums[i - 1]){
                        min = nums[j];
                        minIndex = j;
                    }
                }
                temp = nums[minIndex];
                nums[minIndex] = nums[i - 1];
                nums[i - 1] = temp;
                Arrays.sort(nums,i,nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        new _44_下一个排列().nextPermutation(nums);
    }

}
