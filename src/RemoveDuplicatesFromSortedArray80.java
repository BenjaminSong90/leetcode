import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray80 {
    public static void main(String[] a) {
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {0,0,1,1,1,1,2,3,3};

        System.out.println(new RemoveDuplicatesFromSortedArray80().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int count = 1;
        int edgeP = 1;
        int moveP = 1;

        while (moveP < nums.length){
            if(nums[moveP-1] == nums[moveP]){
                count++;
            }else{
                count = 1;
            }

            if(count<=2){
                nums[edgeP] = nums[moveP];
                edgeP++;
            }

            moveP++;
        }

        return edgeP;
    }
}
