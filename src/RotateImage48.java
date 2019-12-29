import java.util.Arrays;
import java.util.List;

public class RotateImage48 {

    public static void main(String[] a) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        new RotateImage48().rotate(matrix);

        for (int[] xs : matrix) {
            System.out.println(Arrays.toString(xs));
        }

    }

    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int[][] rm = new int[matrix.length][matrix[0].length];

        for (int xsi = 0; xsi < matrix.length; xsi++) {
            for (int ysi = matrix[xsi].length -1; ysi >=0; ysi--) {
                rm[xsi][ysi] = matrix[matrix[xsi].length-1-ysi][xsi];
            }
        }


        for (int xsi = 0; xsi < matrix.length; xsi++) {
            for (int ysi = matrix[xsi].length -1; ysi >=0; ysi--) {
                matrix[xsi][ysi] = rm[xsi][ysi];
            }
        }


    }
}
