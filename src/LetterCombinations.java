import java.util.*;

public class LetterCombinations {

    public static void main(String[] a) {
        System.out.println(Arrays.toString(new LetterCombinations().letterCombinations("23").toArray()));
    }

    Map<String,String> map = new HashMap<>();
    {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }
    List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()<1){
            return new ArrayList<>();
        }

        if(digits.length() == 1){
            return Arrays.asList(map.get(digits).split(""));
        }
        combination("", digits);
        return result;
    }

    public void combination(String s, String next_num){
        if(next_num.length() == 0) {
            result.add(s);
        } else {
            String n = next_num.substring(0,1);
            String l = map.get(n);

            for(int i = 0; i< l.length(); i++){
                String c = l.substring(i,i+1);
                combination(s+c, next_num.substring(1));
            }
        }
    }
}
