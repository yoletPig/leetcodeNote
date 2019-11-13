package BinaryTree;

import DataStructUtils.BinaryTree.TreeNode;

/*
222. 计算完全二叉树的节点个数。
 */
public class CountNodes {
    int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            count++;
        }
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}
