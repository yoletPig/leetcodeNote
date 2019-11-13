package BinaryTree;

import DataStructUtils.BinaryTree.TreeNode;

public class lcaDeepestLeaves {

    int deepest;
    TreeNode NPnode;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        f(root,0,root);
        return NPnode;
    }

    private void f(TreeNode root, int depth, TreeNode Np) {
        if (root==null){
            if (depth>deepest){
                deepest=depth;
                NPnode = Np;
            }
            return;
        }
        if (root.left != null && root.right != null){
            Np = root;
        }
        int t = depth;
        f(root.left,++ depth ,Np);
        depth = t;
        f(root.right, ++depth, Np);
    }

}

