import java.util.LinkedList;
import java.util.List;

public class SimplifyPath71 {

    public static void main(String[] a) {
//        String path = "/home//foo/";
//        String path = "/a/./b/../../c/";
//        String path = "/a/../../b/../c//.//";
//        String path = "/a//b////c/d//././/..";
//        String path = "/home//foo/";
//        String path = "/home/";
//        String path = "/../";
        String path = "/home/../../..";
        System.out.println(new SimplifyPath71().simplifyPath(path));
    }


    public String simplifyPath(String path) {
        String[] r = path.split("/");
        List<String> dirs = new LinkedList<>();
        for(String dirName: r){
            if(dirName.isEmpty() || " ".equals(dirName) || ".".equals(dirName)) continue;
            if ("..".equals(dirName)) {
                if (dirs.size() > 0) {
                    dirs.remove(dirs.size() - 1);
                }
            } else {
                dirs.add(dirName);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        for(int i = 0; i < dirs.size(); i++){
            if(i != 0){
                sb.append("/");
            }
            sb.append(dirs.get(i));
        }
        return sb.toString();
    }
}
