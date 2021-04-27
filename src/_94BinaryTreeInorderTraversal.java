import java.util.LinkedList;
import java.util.List;

public class _94BinaryTreeInorderTraversal {

    public static void main(String[] a) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right.left = new TreeNode(3);


        List<Integer> result = new _94BinaryTreeInorderTraversal().inorderTraversal(root);
        System.out.println("result: "+result.toString());
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        t(result, root);
        return result;
    }

    public void t(List<Integer> result, TreeNode node){
        if(node == null) return;

        t(result, node.left);
        result.add( node.val);
        t(result, node.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
