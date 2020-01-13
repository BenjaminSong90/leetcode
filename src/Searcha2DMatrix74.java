
public class Searcha2DMatrix74 {
    public static void main(String[] a) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {3, 30, 34, 50}
        };
        int target = 3;
        System.out.println("result: " + new Searcha2DMatrix74().searchMatrix(matrix, target));
    }





    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for(int[] row:matrix){
            if(row[row.length-1] < target){
                continue;
            }
            if(row[0] > target){
                return false;
            }
            int left = 0;
            int right = row.length -1;
            while (right>=left){
                if(row[right] == target){
                    return true;
                }else{
                    right--;
                }

                if(row[left] == target){
                    return true;
                }else{
                    left++;
                }
            }
        }

        return false;
    }

}
