import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 *        public String minWindow(String s, String t) {
 *         int[] A = new int[128];
 *         if(s.length() < t.length()) return "";
 *         for(int i=0;i<t.length();i++) A[t.charAt(i)]++;
 *
 *         int l=0, r=0;
 *         for(;r<t.length();r++) A[s.charAt(r)]--;
 *         if(matches(A)) return s.substring(0,r);
 *
 *         String min = s+s;
 *         for(;r<s.length();r++) {
 *             A[s.charAt(r)]--;
 *             if(!matches(A)) continue;
 *             while(matches(A)) A[s.charAt(l++)]++;
 *             String curr = s.substring(l-1,r+1);
 *             if(curr.length() < min.length())  min = curr;
 *         }
 *         return min.length() > s.length() ? "" : min;
 *     }
 *     boolean matches(int[] A){
 *         for(int a:A) if(a>0) return false;
 *         return true;
 *     }
 */
public class _76MinimumWindowSubstring {

    public static void main(String[] a) {
        _76MinimumWindowSubstring t = new _76MinimumWindowSubstring();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("/Users/songlang/Desktop/leetcode/src/76Testcase")));
            BufferedReader br = new BufferedReader(reader);
            String line1 = br.readLine().replace("\"","");
            String line2 = br.readLine().replace("\"","");
            br.close();
            reader.close();

//            line1 = "ADOBECODEBANC";
//            line2 = "ABC";

            System.out.println(">>>>>>"+t.minWindow(line1, line2));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left = 0, right = 0, valid = 0,
                len = Integer.MAX_VALUE, start = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            while (valid == need.size()){
                if(right-left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
