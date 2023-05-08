import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6_三数之和 {

    //注意，每次枚举的数需要与之前的不相同，若相同则有可能会重复
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int i,j,k;
        for (i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){//重要
                continue;
            }
            k = nums.length - 1;
            for (j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]){//重要
                    continue;
                }
                //这面要注意，一定是while
                while(j < k && nums[i] + nums[j] + nums[k] > 0){//不考虑于，因为i与j动不了
                    k--;
                }
                if(j == k){
                    break;
                }
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ret.add(list);
                }
            }
        }
        return ret;
    }

}
