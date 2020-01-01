import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] a) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };

        int[][] matrix = {
                {1},
                {5},
                {9}
        };

        System.out.println(Arrays.toString(new SpiralMatrix54().spiralOrder(matrix).toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;

        int hs = 0, vs = 0;
        int he = matrix[0].length - 1;
        int ve = matrix.length - 1;

        while (hs <= he && vs <= ve) {
            for (int i = hs; i <= he; i++) {
                result.add(matrix[vs][i]);
            }
            vs++;

            if(he >= hs){
                for (int i = vs; i <= ve; i++) {
                    result.add(matrix[i][he]);
                }
                he--;
            }

            if(ve >= vs){
                for (int i = he; i >= hs; i--) {
                    result.add(matrix[ve][i]);
                }
                ve--;
            }

            if(he >= hs){
                for (int i = ve; i >= vs; i--) {
                    result.add(matrix[i][hs]);
                }
                hs++;
            }

        }

        return result;
    }
}
