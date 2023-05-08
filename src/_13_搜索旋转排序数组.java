public class _13_搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        int l = 0,r = nums.length - 1,mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[l]){//无序在左半边
                if(target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }else{//无序在右半边
                if(target < nums[mid] && target >= nums[l])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

}
