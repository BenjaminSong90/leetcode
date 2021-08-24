import java.util.ArrayList;
import java.util.List;

public class _95UniqueBinarySearchTreesII {

    public static void main(String[] a) {
        List<TreeNode> result = new _95UniqueBinarySearchTreesII().generateTrees(3);
        System.out.println("result size: "+result.size());
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        for (int i = l; i <= r; ++i)
            for (TreeNode left : generateTrees(l, i - 1))
                for (TreeNode right: generateTrees(i + 1, r)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
        return ans;
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
