public class _35_二分查找 {

    public int search(int[] nums, int target) {
        int l = 0,r = nums.length - 1,mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

}
