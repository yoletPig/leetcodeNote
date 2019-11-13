package BinaryTree;

import DataStructUtils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class averageOfLevels {
    ArrayList<ArrayList<Integer>> List = new ArrayList<> ();
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> listD = new ArrayList<>();
        perSum(root, 0);
        for (ArrayList<Integer> list : List) {
            long sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            listD.add((double)sum/list.size());
        }
        return listD;
    }

    private void perSum(TreeNode root, int i) {
        if (root == null){
            return;
        }
        if (List.size()<=i){
            List.add(new ArrayList<> ());
        }
        List.get(i).add(root.val);
        perSum(root.left, i+1);
        perSum(root.right, i+1);
    }

    public static void main(String[] args) {

    }
}
