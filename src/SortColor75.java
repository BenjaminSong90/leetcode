import java.util.Arrays;

public class SortColor75 {
    public static void main(String[] a) {
//        int[] colors = {2,0,2,1,1,0};
//        int[] colors = {2};
        int[] colors = {2,2};

        new SortColor75().sortColors(colors);
        System.out.println("result: " + Arrays.toString(colors));
    }


    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }

        int rCount = 0;
        int wCount = 0;
        int bCount = 0;
        for(int i : nums){
            if(i == 0){
                rCount++;
            }
            if(i == 1){
                wCount++;
            }
            if(i == 2){
                bCount++;
            }
        }

        for(int i = 0; i < rCount; i++){
            nums[i]=0;
        }
        for(int i = 0; i < wCount; i++){
            nums[i+rCount]=1;
        }

        for(int i = 0; i < bCount; i++){
            nums[i+rCount+wCount]=2;
        }
    }
}
