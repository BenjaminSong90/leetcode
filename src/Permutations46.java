import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations46 {

    public static void main(String[] a) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = new Permutations46().permute(nums);

        for (List<Integer> l : result) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        g(nums,  new LinkedList<>());

        return result;
    }

    public void g(int[] num,  LinkedList<Integer> r) {
        if (num.length == r.size()) {
            result.add(new ArrayList<>(r));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if(r.contains(num[i])) continue;
            r.add(num[i]);
            g(num,r);
            r.removeLast();
        }
    }
}
