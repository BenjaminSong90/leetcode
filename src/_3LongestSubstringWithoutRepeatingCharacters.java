import java.util.HashMap;
import java.util.Map;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] a) {
        System.out.println(">>>>>>>>>>>>" + new _3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int len = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (window.containsKey(c)) {
                window.put(c, window.get(c) + 1);
            } else {
                window.put(c, 1);
            }

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                int count = window.get(d);
                count--;
                window.put(d, count);


            }
            System.out.println(window);

            len = Math.max(len, right - left);

        }

        return len;
    }
}
