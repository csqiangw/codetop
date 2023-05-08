import java.util.ArrayList;
import java.util.List;

public class _38_二叉树的右视图 {

    //层次遍历，每层最后一个
    public List<Integer> rightSideView(TreeNode root) {
        //每层的最后一个
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        ret.add(root.val);//根节点必定在
        List<TreeNode> queue = new ArrayList<>();
        TreeNode t;
        queue.add(root);
        int front = -1,rear = 0,last = 0;
        while(front != rear){
            front++;
            t = queue.remove(0);
            if(t.left != null){
                queue.add(t.left);
                rear++;
            }
            if(t.right != null){
                queue.add(t.right);
                rear++;
            }
            if(front == last){
                last = rear;
                if(queue.size() == 0){
                    continue;
                }
                ret.add(queue.get(queue.size() - 1).val);
            }
        }
        return ret;
    }

}
