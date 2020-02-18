import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    public static void main(String[] a) {
        List<String> result = new RestoreIPAddresses93().restoreIpAddresses("25525511135");//  "25525511135"  "010010"
        for(String s:result){
            System.out.println(">>"+s);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12||s.length()<4){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        g(result, new ArrayList<String>(),0,s);


        return result;
    }

    public void g(List<String> result, List<String> ip,int index,String s){
        if(ip.size()==4&&index==s.length()){
            result.add(String.join(".",ip));
        }
        

        for(int i = index; i < index+3&&i<s.length(); i++){
            String n = s.substring(index,i+1);
            int num = Integer.parseInt(n);
            if(num>255||(n.charAt(0)=='0'&&n.length()>1)){
                break;
            }else{

                if(ip.size()+1 == 4 && i+1<s.length()){
                    continue;
                }

                List<String> item = new ArrayList<>(ip);
                item.add(n);
                g(result, item,i+1,s);
            }
        }
    }
}
