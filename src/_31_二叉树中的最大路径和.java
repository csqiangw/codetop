/**
 * 思路：
 * 首先不要被整体性带歪，想往左或者往右遍历只能代表整棵树，可以通过返回单枝的数据来拿到部分
 * 其次，直到获取的意义后，可以获取左右子树中的最大值，那么要注意辨别，是否小于0，小于0就没有比较意义了，直接置0
 * 接着比较ret和当前节点+左右（负值已变0）大小，并进行更新
 * 最后返回，一定要注意，是返回当前节点值，还是左右中最大的一个，因为想清楚是单条路径的值
 */
public class _31_二叉树中的最大路径和 {

    public int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return ret;
    }

    public int getMaxPathSum(TreeNode root){
        if(root == null)
            return 0;
        int leftValue = Math.max(0,getMaxPathSum(root.left));
        int rightValue = Math.max(0,getMaxPathSum(root.right));
        this.ret = Math.max(ret,root.val + leftValue + rightValue);
        return Math.max(root.val,Math.max(root.val + leftValue,root.val + rightValue));
    }

}
