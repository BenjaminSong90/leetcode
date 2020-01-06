import java.util.ArrayList;

import java.util.List;

public class PermutationSequence60 {
    public static void main(String[] a) {
        System.out.println("result: "+new PermutationSequence60().getPermutation(3,2));
    }

    public String getPermutation(int n, int k) {
        int[] f = new int[1 + n];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) f[i] = i * f[i-1];

        List<Integer> num = new ArrayList();
        for (int i = 1; i <= n; ++i) num.add(i);

        --k;
        StringBuilder result = new StringBuilder();
        while (num.size() > 1 && k != 0)
        {
            int x = num.size() - 1;
            int seq = k / f[x];
            result.append(num.get(seq));
            num.remove(seq);
            k %= f[x];
        }

        for (int d : num) result.append(d);
        return result.toString();
    }



}
