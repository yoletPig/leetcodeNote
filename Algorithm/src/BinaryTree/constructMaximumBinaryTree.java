package BinaryTree;

import DataStructUtils.BinaryTree.*;

/**
 * 654. 最大二叉树
 * 难度
 * 中等
 *
 * 73
 *
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 通过次数
 * 6,122
 * 提交次数
 * 8,027
 * 题目描述
 * 评论 (101)
 * 题解(25)New
 * 提交记录
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createIt(nums, 0, nums.length);
    }

    private TreeNode createIt(int[] nums,int left, int right) {
        int maxValue = Integer.MIN_VALUE;
        int posMax = 0;
        for (int i = left; i < right; i++) {
            if (nums [i]>maxValue){
                maxValue = nums [i];
                posMax = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        if (left<posMax)
        {
            root.left = createIt(nums, left, posMax);
        }
        if (posMax+1<right)
        {
            root.right = createIt(nums, posMax+1, right);
        }
        return root;
    }

    public static void main(String[] args) {
        constructMaximumBinaryTree ct =new constructMaximumBinaryTree();
        int [] nums = {5,1};
        TreeNode treeNode = ct.constructMaximumBinaryTree(nums);
        DataStructUtils.BinaryTree.TreeNodeUtils.showTree(treeNode);
    }
}
