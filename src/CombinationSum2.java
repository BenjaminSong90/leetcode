import java.util.*;

public class CombinationSum2 {
    public static void main(String[] a) {
        int[] s = {2,5,2,1,2};


        List<List<Integer>> r = new CombinationSum2().combinationSum2(s,5);

        for(List<Integer> l : r){

            System.out.println("list: "+ Arrays.toString(l.toArray()));

        }
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int index = 0; index < candidates.length; index++) {
            if( index > 0&& candidates[index] == candidates[index-1]) continue;
            add(new ArrayList<>(0), index, candidates, target, 0);
        }
        return result;
    }

    public void add(List<Integer> l, int index, int[] candidates, int target, int sum){

        int addResult = sum+candidates[index];
        if(addResult == target){
            l.add(candidates[index]);
            result.add(l);
            return;
        }

        if(addResult > target){
            return;
        }
        l.add(candidates[index]);
        if(index >= candidates.length-1){
            return;
        }
        for(int i = index+1; i < candidates.length; i++){
            if( i > index+1&& candidates[i] == candidates[i-1]) continue;
            add(new ArrayList<>(l),i,candidates,target,addResult);
        }
    }
}
