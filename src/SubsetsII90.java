import java.util.*;

public class SubsetsII90 {

    public static void main(String[] a) {

        int[] nums = {1, 1, 2, 2};

        List<List<Integer>> result = new SubsetsII90().subsetsWithDup(nums);

        for(List<Integer> i:result){
            System.out.println(Arrays.toString(i.toArray()));
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());

        Arrays.sort(nums);
        for (int number: nums) {
            Set<List<Integer>> additionalResults = new HashSet<>();
            for (List<Integer> partialResult : result) {
                List<Integer> partialResultCopy = new ArrayList<>(partialResult);
                partialResultCopy.add(number);
                additionalResults.add(partialResultCopy);
            }
            result.addAll(additionalResults);
        }

        return new ArrayList<>(result);
    }
}
