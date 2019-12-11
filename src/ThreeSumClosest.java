import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] a) {
//        int[] nums = {-4, -1, -1, 0, 1, 2};
        int[] nums = {0,2,1,-3};

        int result = new ThreeSumClosest().threeSumClosest(nums, 0);

        System.out.println("result:"+result);

    }

    public int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length<3){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int start = i+1;
            int end = nums.length-1;

            while (end>start){
                int sum = nums[i] + nums[end] + nums[start];
                int distance = Math.abs(sum - target);
                if(distance == 0){
                    return target;
                }
                if(distance < min){
                    min = distance;
                    result = sum;
                }
                
                
                if(sum<target){
                    start++;
                }
                if(sum > target){
                    end--;
                }
            }
        }

        return result;
    }
}
