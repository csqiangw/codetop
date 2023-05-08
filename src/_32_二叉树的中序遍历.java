import java.util.ArrayList;
import java.util.List;

public class _32_二叉树的中序遍历 {

    public void inOrder(TreeNode root,List<Integer> ret){
        if(root != null){
            inOrder(root.left,ret);
            ret.add(root.val);
            inOrder(root.right,ret);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrder(root,ret);
        return ret;
    }

}
