import java.util.HashMap;
import java.util.Map;

public class _567PermutationInString {
    public static void main(String[] args){
        System.out.println("result>>>>"+new _567PermutationInString().checkInclusion("abc", "bbbca"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>(),
                need = new HashMap<>();
        for(char c:s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        boolean result = false;

        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                Integer ws = window.getOrDefault(c,0);
                ++ws;
                window.put(c,ws);
                if(need.get(c).equals(ws)){
                    valid++;
                }
            }
            while (valid == need.size()){
                if(right-left < len){
                    len = right - left;
                }
                char d = s2.charAt(left);

                left++;
                if(need.containsKey(d)){
                    int ws = window.getOrDefault(d, 0);
                    if(need.get(d).equals(ws)){
                        valid--;
                    }
                    --ws;
                    window.put(d, ws);
                }
                if(valid != need.size()){
                    if(len == s1.length()){
                        result = true;
                    }
                }

            }
        }

        return result;
    }
}
