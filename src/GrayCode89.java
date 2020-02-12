import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode89 {

    public static void main(String[] a) {


        List<Integer> result = new GrayCode89().grayCode(2);

        System.out.println(">>>>>>>>>>result: "+ Arrays.toString(result.toArray()));

    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; ++i) {
            int size = res.size();
            for (int j = size - 1; j >= 0; --j) {
                res.add(res.get(j) | (1 << i));
            }
        }
        return res;
    }
}
