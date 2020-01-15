import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations77 {
    public static void main(String[] a) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = new Combinations77().combine(n,k);

        for(List<Integer> i : result){
            System.out.println(Arrays.toString(i.toArray()));
        }


    }

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        generater(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void generater(int start, int n, int k, List<List<Integer>> result, List<Integer> ans) {
        if (ans.size() == k) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i <= n; i++) {
            ans.add(i);
            generater(i + 1, n, k, result, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
