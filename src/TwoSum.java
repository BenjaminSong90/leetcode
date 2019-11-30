import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        int[] data = new int[]{2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(new TwoSum().twoSum(data,target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] data = new int[2];

        for(int i = 0; i < nums.length; i++){
            int d = target - nums[i];
            if(m.containsKey(nums[i])){
                data[0] = m.get(nums[i]);
                data[1] = i;
                return data;
            }
            m.put(d,i);
        }

        return data;
    }
}
