import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] a) {
        int[] s = {1};


        List<List<Integer>> r = new CombinationSum().combinationSum(s,7);

        for(List<Integer> l : r){

                System.out.println("list: "+ Arrays.toString(l.toArray()));

        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int index = 0; index < candidates.length; index++) {
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

        for(int i = index; i < candidates.length; i++){
            add(new ArrayList<>(l),i,candidates,target,addResult);
        }
    }
}
