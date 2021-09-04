import java.util.Arrays;
import java.util.Comparator;

public class _354RussianDollEnvelopes {
    public static void main(String[] args){
//        int[][] mails = new int[][]{{1,15},{7,18},{7,6},{7,100},{2,200},{17,30},{17,45},{3,5},{7,8},{3,6},{3,10},{7,20},{17,3},{17,45}};
//        int[][] mails = new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}};
        int[][] mails = new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(">>>>>>>>>>>"+new _354RussianDollEnvelopes().maxEnvelopes(mails));
    }

    //我这里写的并不是最优解，数据和内存都不是很好，但是最为一个记录
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[1] - o2[0]*o2[1];
            }
        });
//        for(int i = 0; i < envelopes.length; i++){
//            for(int j = i; j < envelopes.length;  j++){
//                if(envelopes[i][0]*envelopes[i][1] > envelopes[j][0]*envelopes[j][1]){
//                    int[]swap = envelopes[i];
//                    envelopes[i] = envelopes[j];
//                    envelopes[j] = swap;
//                }
//            }
//        }

        int[] tag = new int[envelopes.length];
        Arrays.fill(tag, 1);
        int max = 1;

        for(int i = 0; i< envelopes.length; i++){
            for(int j = 0; j < i; j++){
                if(canAdd(envelopes[j], envelopes[i])){
                    tag[i] = Math.max(tag[i], tag[j]+1);
                    max = Math.max(tag[i], max);
                }
            }
        }

        return max;
    }

    public boolean canAdd(int[] first, int[] second){
        return second[0] > first[0] && second[1] > first[1];
    }
}
