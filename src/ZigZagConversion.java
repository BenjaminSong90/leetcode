public class ZigZagConversion {
    public static void main(String[] a) {
        System.out.println(new ZigZagConversion().convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        int col = s.length();
        if(col == 0 || numRows == 1){
            return s;
        }
        StringBuilder[] sA = new StringBuilder[numRows];
        boolean isDown = true;
        int y = 0;

        for(int i = 0; i<s.length(); i++){
            if(y<numRows && y>=0){
                if(sA[y] == null){
                    sA[y] = new StringBuilder();
                }
                sA[y].append(s.charAt(i));
            }
            if(y == (numRows-1)){
                isDown = false;
            }
            if(y == 0){
                isDown = true;
            }
            if(isDown){
                y++;
            } else {
                y--;
            }

        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder b : sA){
            if(b == null){
                continue;
            }
            result.append(b);
        }

        return result.toString();
    }
}
