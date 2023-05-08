import java.util.ArrayDeque;

public class _48_滑动窗口最大值 {

    //Java中的双端队列是ArrayDequeue
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        int index = 0,removeIndex = 0;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while(!arrayDeque.isEmpty() && nums[i] > arrayDeque.getLast())
                arrayDeque.removeLast();
            arrayDeque.offer(nums[i]);
        }
        ret[index++] = arrayDeque.getFirst();
        for (int i = k; i < nums.length; i++) {
            if(nums[removeIndex++] == arrayDeque.getFirst())
                arrayDeque.poll();
            while(!arrayDeque.isEmpty() && nums[i] > arrayDeque.getLast())
                arrayDeque.removeLast();
            arrayDeque.offer(nums[i]);
            ret[index++] = arrayDeque.getFirst();
        }
        return ret;
    }

}
