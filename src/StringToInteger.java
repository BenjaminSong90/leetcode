public class StringToInteger {
    public static void main(String[] a) {
        System.out.println(new StringToInteger().myAtoi(" -1212121 121"));
    }

    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int i = 0;
        int sign = 1;
        int len = str.length();
        int num = 0;
        while(i < len && str.charAt(i) == ' ') ++i;

        if(i < len &&(str.charAt(i) == '+'|| str.charAt(i) == '-')){
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }

        while (i < len && str.charAt(i) >= '0' && str.charAt(i)<= '9'){
            if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && str.charAt(i)-'0'>7)){
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = 10 * num + (str.charAt(i++) - '0');
        }

        return num * sign;


    }
}
