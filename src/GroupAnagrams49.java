import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] a) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> r = new GroupAnagrams49().groupAnagrams(strs);

        for(List<String> sl : r){
            System.out.println(Arrays.toString(sl.toArray()));
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> m = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String s : strs){
            char[] sa = s.toCharArray();
            Arrays.sort(sa);
            int hc = Arrays.hashCode(sa);
            List<String>  v = m.get(hc);
            if(v == null){
                v= new ArrayList<>();
                m.put(hc,v);
                result.add(v);
            }
            v.add(s);
        }

        return result;
    }
}
