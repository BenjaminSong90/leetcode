
public class Pow50 {
    public static void main(String[] a) {
        System.out.println("result : "+ new Pow50().myPow(0.00001,2147483647));
    }

    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        return pow(x, N);

    }

    public double pow(double x, long N){
        if(N == 0) return 1;
        if(N == 1) return x;
        double temp = pow(x, N/2);
        if(N%2==0)
            return temp*temp;
        else
            return temp*temp*x;
    }

}
