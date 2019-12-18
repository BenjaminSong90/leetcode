import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] a) {
        int[] nums = {3,1,2,4,3,1};
//        int[] nums = {4,3,2,1,1};
        new NextPermutation().nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >=nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);

    }

    public void reverse(int[] nums,int index){
        int start = index;
        int end = nums.length -1;
        while (end > start){
            swap(nums,start, end);
            end--;
            start++;
        }
    }

    public void swap(int[] nums, int n, int m){
        int i = nums[n];
        nums[n] = nums[m];
        nums[m] = i;
    }
}
