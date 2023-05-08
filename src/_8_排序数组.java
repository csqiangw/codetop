public class _8_排序数组 {

    /**
     * 对数组排序，选择快排
     */
    int parition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low < high){
            while(low < high && pivot >= nums[high]) high--;
            while(low < high && pivot <= nums[low]) low++;
        }
        nums[low] = pivot;
        return low;
    }

    public void quickSort(int[] nums,int low,int high){
        while(low < high){
            int pivotpos = parition(nums,low,high);
            quickSort(nums,low,pivotpos - 1);
            quickSort(nums,pivotpos + 1,high);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

}
