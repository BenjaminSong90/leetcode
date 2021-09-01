import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _438FindAllAnagramsInAString {
    public static void main(String[] args){
        System.out.println(">>>>>>>>>"+new _438FindAllAnagramsInAString().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> window = new HashMap<>(),need = new HashMap<>();
        for(char c: p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0;
        int valid = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            } else {
                left = right;
                window.clear();
                valid = 0;
            }
            System.out.println(window + "  "+right +"  "+left + "  "+valid);

            while (valid == need.size()){
                if(right - left == p.length())
                    result.add(left);
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return result;

    }
}
