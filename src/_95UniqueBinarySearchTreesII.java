import java.util.ArrayList;
import java.util.List;

public class _95UniqueBinarySearchTreesII {

    public static void main(String[] a) {
        List<TreeNode> result = new _95UniqueBinarySearchTreesII().generateTrees(3);
        System.out.println("result size: "+result.size());
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 2][n + 2];
        for(int i = 1; i <= n + 1; i++) {
            dp[i][i - 1] = new ArrayList<>();
            dp[i][i - 1].add(null);
        }
        for(int len = 0; len < n; len++) {
            for(int i = 1; i + len <= n; i++) {
                int j = i + len;
                dp[i][j] = new ArrayList<>();
                if(len == 0) {
                    dp[i][j].add(new TreeNode(i));
                } else {
                    for(int k = i; k <= j; k++) {
                        for(TreeNode left : dp[i][k - 1]) {
                            for(TreeNode right : dp[k + 1][j]) {
                                dp[i][j].add(new TreeNode(k, left, right));
                            }
                        }
                    }
                }
            }
        }
        return dp[1][n];
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
