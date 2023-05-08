import java.util.ArrayList;

import java.util.List;

public class _21_全排列 {

    public List<List<Integer>> ret;
    
    public void getPermute(List<Integer> list,int[] nums){
        if(list.size() == nums.length){
            ret.add(new ArrayList<>(list));//可以通过构造函数构造一个新的
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                continue;//若包含这个了，就不要再添加了，直接跳过
            list.add(nums[i]);
            //继续往下走
            getPermute(list,nums);
            //用完了，该往上回退了，此时也要退 回退表中最后一个即可
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<Integer> list = new ArrayList<>();
        ret = new ArrayList<>();
        getPermute(list,nums);
        return ret;
    }

}
