import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals56 {
    public static void main(String[] a) {
//        int[][] data = {{1,3},{2,6},{8,10},{15,18}};
        int[][] data = {{1,4},{2,3}};
        int[][] result = new MergeIntervals56().merge(data);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
    }



    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        int[][] result = new int[merged.size()][];
        int i = 0;
        for(int[] cur : merged) result[i++] = cur;

        return result;
    }
}
