import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] a) {
        System.out.println(new IntegerToRoman().intToRoman(11));
    }

    public String intToRoman(int num) {
        int key = 10;
        StringBuilder roman = new StringBuilder();
        Map<Integer,String> rMap = new HashMap<>();
        rMap.put(1,"I");
        rMap.put(4,"IV");

        rMap.put(5,"V");
        rMap.put(9,"IX");

        rMap.put(10,"X");

        rMap.put(40,"XL");
        rMap.put(50,"L");

        rMap.put(90,"XC");
        rMap.put(100,"C");

        rMap.put(400, "CD");
        rMap.put(500,"D");

        rMap.put(900,"CM");
        rMap.put(1000,"M");
        int tagNum = num;

        do {
            int middle = key / 2;
            int step_start = key / 10;
            int check = tagNum % key;
            String stepS = rMap.get(step_start);
            String middleS = rMap.get(middle);

            if(stepS == null || middleS == null){
                break;
            }

            if (rMap.containsKey(check)) {
                roman.insert(0, rMap.get(check));
            } else {
                if (check < middle) {
                    for (int i = step_start; i <= check; i += step_start) {
                        roman.insert(0, stepS);
                    }
                } else {
                    for (int i = middle + 1; i <= check; i += step_start) {
                        roman.insert(0, stepS);
                    }
                    roman.insert(0, middleS);
                }
            }

            tagNum = tagNum / key * key;
            key *= 10;
        } while (tagNum != 0);
        return roman.toString();

//下面是另一种解法
//        String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//        int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        String ret = "";
//        for(int i=0; i<13; i++) {
//            if(num>=val[i]) {
//                int count = num/val[i];
//                num %= val[i];
//                for(int j=0; j<count; j++) {
//                    ret = ret + dict[i];
//                }
//            }
//        }
//        return ret;

    }
}
