package BinaryTree;
import	java.util.ArrayList;

import DataStructUtils.BinaryTree.TreeNode;

import java.util.List;

public class binaryTreePaths {
    ArrayList<String> list = new ArrayList<String> ();
    public List<String> binaryTreePaths(TreeNode root) {
        f(root,new StringBuilder());
        return list;
    }

    private void f(TreeNode root,StringBuilder sb){
        if (root!=null){
            if (root.left != null||root.right != null){
                sb.append(root.val+"->");
                StringBuilder t = new StringBuilder(sb);
                f(root.left, sb);
                sb = t;
                f(root.right, sb);
            }else {
                sb.append(root.val);
                if (!list.contains(sb.toString())){
                    list.add(sb.toString());
                }
            }
        }
        else {
            return;
        }
    }
}
