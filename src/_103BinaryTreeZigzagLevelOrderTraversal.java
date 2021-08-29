import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        List<List<Integer>> result = new _103BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node);
        System.out.println("Result>>>>>>"+ result);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isNormal = true;

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(isNormal){
                    level.add(node.val);

                } else {
                    level.add(0, node.val);
                }

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            isNormal = !isNormal;
            result.add(level);

        }

        return result;
    }
}
