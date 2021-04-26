import javafx.util.Pair;

import java.util.Arrays;

public class _85MaximalRectangle {

    public static void main(String[] a) {
        char[][] test = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}

                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'0','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}


        };
        int result = new _85MaximalRectangle().maximalRectangle(test);
        System.out.println("result:"+result);
    }

    int[][] RL;

    public int maximalRectangle(char[][] matrix) {
        int y,x;
        if((y = matrix.length) == 0 || (x = matrix[0].length) == 0) return 0;
        RL = new int[y][x];
        int max = 0;
        for(int sy = 0; sy < y; sy++){
            for(int sx = 0; sx < x; sx++){
                RL[sy][sx] = sx == 0?matrix[sy][sx] -'0' : matrix[sy][sx] == '0'? 0 : RL[sy][sx-1]+1;
            }
            System.out.println(Arrays.toString(RL[sy]));
        }

        for(int sy = y-1; sy >= 0; sy--){
            for(int sx = x-1; sx >= 0; sx--){
                int wid = RL[sy][sx];
                int h = 1;
                int point = sy;
                while (wid > 0 && point >=0){
                    wid = Math.min(wid, RL[point][sx]);
                    max = Math.max(wid*h, max);
                    h++;
                    point--;
                }
            }
        }
        return max;
    }

//    public int maximalRectangle(char[][] matrix) {
//        int yEnd = matrix.length;
//        if(yEnd == 0) return 0;
//        int xEnd = matrix[0].length;
//        if(xEnd == 0) return 0;
//        int size = 0;
//        for(int y = yEnd-1; y>=0; y--){
//            for(int x = xEnd-1; x>=0; x--){
//                int s1 = xArea(matrix, x,y);
//                int s2 = yArea(matrix, x, y);
//                int s3 = area(matrix, x, y);
//                System.out.println("s1:"+s1+"  s2:"+s2+"  s3:"+s3);
//                int max = 0;
//                if(s1 > s2){
//                    max = s1;
//                } else {
//                    max = s2;
//                }
//                if(s3 > max){
//                    max = s3;
//                }
//
//                if(max > size){
//                    size = max;
//                }
//            }
//
//        }
//        return size;
//    }
//
//    private int xArea(char[][] test, int pointX, int pointY){
//        if(test[pointY][pointX] == '0') return 0;
//        int size = 0;
//        for(int startX = pointX; startX >= 0; startX--){
//            if(test[pointY][startX] != '0'){
//                size++;
//            } else {
//                break;
//            }
//        }
//
//        return size;
//    }
//
//    private int yArea(char[][] test, int pointX, int pointY){
//        if(test[pointY][pointX] == '0') return 0;
//        int size = 0;
//        for(int startY = pointY; startY >= 0; startY--) {
//            if (test[startY][pointX] != '0') {
//                size++;
//            } else {
//                break;
//            }
//        }
//        return size;
//    }
//
//    private int area(char[][] test, int pointX, int pointY){
//        if(test[pointY][pointX] == '0') return 0;
//
//        int size = 0;
//
//        for(int y= pointY-1; y >= 0; y--){
//            for(int x= pointX-1; x >= 0; x--){
//                int s = areaSize(test, x,y, pointX, pointY);
//                if(s == 0){
//                    break;
//                } else {
//                    if(s > size) size = s;
//                }
//            }
//        }
//
//        return size;
//    }
//
//    private int areaSize(char[][] test, int sX, int sY, int endX, int endY){
//        int size = 0;
//        for(int x = sX; x <= endX; x++){
//            for(int y = sY; y <= endY; y++){
//                if(test[y][x] == '0'){
//                    return 0;
//                } else {
//                    size++;
//                }
//            }
//        }
//        return size;
//    }



}
