import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void main(String[] a) {
//        int[][] data = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };

        int[][] data = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new SetMatrixZeroes73().setZeroes(data);

        for (int[] ia : data) {
            System.out.println(Arrays.toString(ia));
        }
    }


    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int y = matrix.length;
        int x = matrix[0].length;
        int[][] cm = new int[y][x];
        for (int i = 0; i < y; i++) {
            System.arraycopy(matrix[i], 0, cm[i], 0, matrix[i].length);
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (cm[i][j] == 0){
                    for (int ti = 0; ti < y; ti++) {
                        matrix[ti][j] = 0;
                    }

                    for (int tj = 0; tj < x; tj++) {
                        matrix[i][tj] = 0;
                    }
                }
            }
        }


    }
}
