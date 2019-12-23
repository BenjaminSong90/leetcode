import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] a) {
        char[][] s = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        System.out.println("is valid: " + new ValidSudoku().isValidSudoku(s));
    }

    public boolean isValidSudoku(char[][] board) {
        List<Character> ccs_v = new ArrayList<>();
        List<Character> ccs_h = new ArrayList<>();
        List<Character> css_g = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            ccs_v.clear();
            ccs_h.clear();
            css_g.clear();
            for (int j = 0; j < board.length; j++) {
                if (ccs_v.contains(board[j][i])) {
                    return false;
                }
                if ('1' <= board[j][i] && board[j][i] <= '9') {
                    ccs_v.add(board[j][i]);
                }

                if (ccs_h.contains(board[i][j])) {
                    return false;
                }
                if ('1' <= board[i][j] && board[i][j] <= '9') {
                    ccs_h.add(board[i][j]);
                }

                if (css_g.contains(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3])) {
                    return false;
                }
                if ('1' <= board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] && board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] <= '9') {
                    css_g.add(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3]);
                }
            }
        }


        return true;
    }
}
