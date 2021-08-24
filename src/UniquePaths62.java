public class UniquePaths62 {
    public static void main(String[] a) {
        System.out.println(new UniquePaths62().uniquePaths(2,2));
    }

//    int count = 0;//超时  时间 n平方

//    public int uniquePaths(int m, int n) {
//        calPath(m,n,0,0);
//        return count;
//    }
//
//    public void calPath(int m,int n, int right, int down){
//
//        if(right == m-1 && down == n-1){
//            count++;
//            return;
//        }
//        if(right < m-1){
//            int nextR = 1+right;
//            calPath(m,n,nextR,down);
//        }
//
//        if(down < n-1){
//            calPath(m,n,right,++down);
//        }
//
//    }


    //技算下一个范围的可能性 有限计算次数
    public int uniquePaths(int m, int n) {

        int[][] arr = new int[m][n];
        return robot(0,0,arr);

    }

    public int robot(int m, int n, int[][] arr){

        if(m<0||m>arr.length-1||n<0||n>arr[0].length-1)return 0;
        if(arr[m][n]!=0)return arr[m][n];
        if(m==arr.length-1&&n==arr[0].length-1)return 1;
        int j = robot(m,n+1,arr);
        int i = robot(m+1,n,arr);
        arr[m][n] = i+j;
        return i+j;

    }

/* 倒推法
public int uniquePaths(int m, int n)
    {

        int[][] num = new int[n][m];
        num[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i + 1 < n && j + 1 < m) {
                    num[i][j] = num[i + 1][j] + num[i][j + 1];
                } else if (i + 1 < n) {
                    num[i][j] = num[i + 1][j];
                } else if (j + 1 < m) {
                    num[i][j] = num[i][j + 1];
                }
            }
        }
        return num[0][0];
    }
*/



}
