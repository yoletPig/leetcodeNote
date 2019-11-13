package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        //保存每一层的结点从左到右
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();

        if (root != null) {
            //入队(尾部)
            queue.offer(root);
            //队列不为空
            while(!queue.isEmpty()) {
                //保存当前root结点的子节点（左->右）
                List<Integer> list = new ArrayList<>();
                int count = queue.size();
                //对队列进行遍历
                for(int i = 0; i < count; i++) {
                    Node cur = queue.poll();
                    for(Node node : cur.children) {
                        queue.add(node);
                    }
                    // add current node value
                    list.add(cur.val);
                }
                // add this level value
                result.add(list);
            }
        }
        return result;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}