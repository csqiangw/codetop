public class _20_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)//存在相等就返回，为空代表往下找到空了，也代表没有找不到
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)//若left与right都不为空，则此时root就是根
            return root;
        if(left != null)//若只找到一个，则也向上返回，因为还可能存在更上面大的树
            return left;
        if(right != null)
            return right;
        return null;//代表在以这个root分支的跟节点中不存在p 与 q
    }

}
