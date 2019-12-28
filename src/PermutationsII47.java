import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47 {
    public static void main(String[] a) {

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = new PermutationsII47().permuteUnique(nums);

        for (List<Integer> l : result) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        g(new ArrayList<>(),nums,new boolean[nums.length]);
        return result;
    }

    public void g(List<Integer> l, int[] nums, boolean[] status){
        System.out.println(Arrays.toString(status));
        if(l.size() == nums.length){
            result.add(new ArrayList<>(l));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(status[i])
                continue;
            if(i>0 && nums[i] == nums[i-1] && status[i-1]) continue;
            l.add(nums[i]);
            status[i] = true;
            g(l,nums,status);
            status[i] = false;
            l.remove(l.size()-1);
        }
    }

}
