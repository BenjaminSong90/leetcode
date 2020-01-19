public class SearchInRotatedSortedArrayII81 {
    public static void main(String[] a) {
//        int[] nums = {2,5,6,0,0,1,2};

//        int[] nums = {2,5,6,0,0,0,2};

        int[] nums = {1,3,1,1,1};
        System.out.println(new SearchInRotatedSortedArrayII81().search(nums,3));
    }



//    public boolean search(int[] nums, int target) {
//        int start = 0;
//        int end= nums.length-1;
//
//        while (start<=end){
//            if(nums[start] == target || nums[end] == target){
//                return true;
//            }
//
//            start++;
//            end--;
//
//        }
//
//        return false;
//
//    }

    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        if(target>nums[0]){
            int i=1;
            while(i<nums.length){
                if(target<nums[i]){
                    return false;
                }else if(target==nums[i]){
                    return true;
                }
                i++;
            }
        }else if(target<nums[0]){
            int i=nums.length-1;
            while(i>0){
                if(target>nums[i]){
                    return false;
                }else if(target==nums[i]){
                    return true;
                }
                i--;
            }
        }
        else{
            return true;
        }

        return false;

    }


}
