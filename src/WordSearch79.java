
public class WordSearch79 {
    public static void main(String[] a) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };


        boolean r = new WordSearch79().exist(board, "ABCCED");

        System.out.println(r);
    }


    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean flag;

    private boolean dfs(char[][] board, int i, int j, String word, int cur) {
        if (cur == word.length()) {
            flag = true;
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(cur)) {
            return false;
        }
        if (!flag) {
            char c = board[i][j];
            board[i][j] = '.';
            boolean ret1 = dfs(board, i + 1, j, word, cur + 1);
            boolean ret2 = dfs(board, i - 1, j, word, cur + 1);
            boolean ret3 = dfs(board, i, j + 1, word, cur + 1);
            boolean ret4 = dfs(board, i, j - 1, word, cur + 1);
            board[i][j] = c;
            return ret1 || ret2 || ret3 || ret4;
        } else {
            return true;
        }
    }

}
