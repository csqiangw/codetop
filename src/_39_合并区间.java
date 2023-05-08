import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _39_合并区间 {

    public int[][] merge(int[][] intervals) {
        //首先按照第一位进行排序，不然会出现[1,4] [0,4]这时程序就会出错
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //下面就挨个比end 与下一位的start，小了就输出，大了就继续
        int start = intervals[0][0],end = intervals[0][1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(end < intervals[i][0]){
                //利用start与end生成新的区间
                list.add(start);
                list.add(end);
                start = intervals[i][0];
                end = intervals[i][1];
            }else
                end = Math.max(end,intervals[i][1]);
        }
        list.add(start);
        list.add(end);
        int[][] ret = new int[list.size() / 2][2];
        for (int i = 0; i < list.size(); i += 2) {
            ret[i / 2][0] = list.get(i);
            ret[i / 2][1] = list.get(i + 1);
        }
        return ret;
    }

}
