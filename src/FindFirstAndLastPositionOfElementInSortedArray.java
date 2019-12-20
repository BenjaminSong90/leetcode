import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] a) {
        int[] nums = {2,2};
        int[] result = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 2);

        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1,-1};
        int start = 0;
        int end = nums.length -1;
        while (end>=start){
            if(nums[start] == target){
                result[0] = start;
            } else {
                if(result[0] == -1){
                    start++;
                }
            }

            if(nums[end] == target){
                result[1] = end;
            } else {
                if(result[1] == -1){
                    end--;
                }
            }

            if(result[0] != -1 && result[1] != -1){
                break;
            }
        }
        return result;
    }
}
