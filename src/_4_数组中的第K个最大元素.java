public class _4_数组中的第K个最大元素 {

    public int parition(int nums[],int left,int right,int k){
        int pivot = nums[left],left_temp = left,right_temp = right;
        while(left_temp < right_temp){
            while(left_temp < right_temp && nums[right_temp] >= pivot) right_temp--;
            nums[left_temp] = nums[right_temp];
            while(left_temp < right_temp && nums[left_temp] <= pivot) left_temp++;
            nums[right_temp] = nums[left_temp];
        }
        nums[left_temp] = pivot;
        if(left_temp == k){
            return pivot;
        }else if(k < left_temp){
            return parition(nums,left,left_temp - 1,k);
        }else{
            return parition(nums,left_temp + 1,right,k);
        }
    }

    //快速排序，划分
    public int findKthLargest(int[] nums, int k) {
        return parition(nums,0,nums.length - 1,nums.length - k);
    }

}
