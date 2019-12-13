import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] a) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};

        List<List<Integer>> result = new FourSum().fourSum(nums, 0);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum < target - nums[i] - nums[j]) left++;
                    if (sum > target - nums[i] - nums[j]) right--;
                    if (sum == (target - nums[i] - nums[j])) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        int temp1 = nums[left];
                        int temp2 = nums[right];
                        while (left < right && nums[left] == temp1) left++;
                        while (left < right && nums[right] == temp2) right--;
                    }
                }
                while (j + 1 < nums.length - 2 && nums[j + 1] == nums[j]) j++;
            }
            while (i + 1 < nums.length - 3 && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }
}
