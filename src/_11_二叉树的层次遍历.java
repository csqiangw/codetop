import java.util.*;

public class _11_二叉树的层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        List<Integer> list = new ArrayList<>();
        int front = -1,rear = 0,last = 0,num = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            front++;
            list.add(root.val);
            if(root.left != null){
                queue.offer(root.left);
                rear++;
            }
            if(root.right != null){
                queue.offer(root.right);
                rear++;
            }
            if(front == last){
                if(num % 2 == 0){//反转
                    Collections.reverse(list);
                }
                num++;
                ret.add(list);
                list = new ArrayList<>();
                last = rear;
            }
        }
        return ret;
    }

}
