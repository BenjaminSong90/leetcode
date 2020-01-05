import java.util.Arrays;

public class SpiralMatrix59 {
    public static void main(String[] a) {
        int[][] result = new SpiralMatrix59().generateMatrix(3);
        for(int[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] generateMatrix(int n) {
        if(n == 1){
            return new int[][]{{1}};
        }
        int hs = 0;
        int he = n-1;
        int vs = 0;
        int ve = n-1;

        int[][] r = new int[n][n];
        int index = 0;



        while (hs<=he){
            for(int i = hs; i <= he; i++){
                index++;
                r[vs][i]=index;
            }
            vs++;

            if(he >= hs) {
                for (int i = vs; i <= ve; i++) {
                    index++;
                    r[i][he] = index;
                }
                he--;
            }

            if(ve >= vs) {
                for (int i = he; i >= hs; i--) {
                    index++;
                    r[ve][i] = index;
                }
                ve--;
            }

            if(he >= hs) {
                for (int i = ve; i >= vs; i--) {
                    index++;
                    r[i][hs] = index;
                }
                hs++;
            }
        }

        return r;

    }
}
