import java.util.*;

public class ThreeSum {
    public static void main(String[] a) {
//        int[] nums = {-4, -1, -1, 0, 1, 2};
        int[] nums = {0,0,0};

        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + ", ");
            }

            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            do {
                if (nums[left] + nums[right] == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    result.add(l);
                    left++;
                    right--;

                    while (nums[left] == nums[left-1]){
                        if(left>= right){
                            break;
                        }
                        left++;

                    }
                    while (nums[right] == nums[right+1]){
                        if(left>= right){
                            break;
                        }
                        right--;
                    }
                }

                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                }

            } while (left < right);
        }

        return result;
    }
}
