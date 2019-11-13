package DataStructUtils.BinaryTree;

import BinaryTree.CountNodes;

public class TreeNodeUtils {
    //创建二叉树
    public static void createTree(TreeNode root,int value){
        if (value <= root.val){
            if (root.left == null){
                root.left = new TreeNode(value);
            }
            else {
                createTree(root.left, value);
            }

        }
        if (value > root.val){
            if (root.right == null){
                root.right = new TreeNode(value);
            }
            else {
                createTree(root.right, value);
            }
        }
    }

    //打印二叉树
    public static void showTree(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val);
        showTree(root.left);
        showTree(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        TreeNode root = new TreeNode(1);
        for (int i : arr) {
            createTree(root,i);
        }
        showTree(root);
        System.out.println();
        CountNodes c= new CountNodes();
        int i = c.countNodes(root);
        System.out.println(i);
    }
}
