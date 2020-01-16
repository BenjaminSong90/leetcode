import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
    public static void main(String[] a) {
        int[] nums = {1,2,3};


        List<List<Integer>> r = new Subsets78().subsets(nums);

        for(List<Integer> l : r){

            System.out.println("list: "+ Arrays.toString(l.toArray()));

        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generator(0,nums,result,new ArrayList<>());

        return result;
    }

    private void generator(int s, int[] nums, List<List<Integer>> result, List<Integer> ans){
        result.add(new ArrayList<>(ans));
        for(int i = s; i < nums.length; i++){
            ans.add(nums[i]);
            generator(i+1,nums,result,ans);
            ans.remove(ans.size()-1);
        }
    }
}
