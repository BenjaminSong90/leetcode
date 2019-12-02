import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] a) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                startIndex = Math.max(startIndex, map.get(s.charAt(i)));
            }
            max = Math.max(max, i - startIndex + 1);

            map.put(s.charAt(i), i + 1);
        }
        return max;
    }
}
