import java.util.HashMap;
import java.util.Map;

public class _650_2KeysKeyboard {

    public static void main(String[] args){
        System.out.println("result>>>>"+new _650_2KeysKeyboard().minSteps(3));
    }
    public int minSteps(int n) {
        return step(n,1,0,0,0);
    }

    /**
     *
     * @param tag 0 复制全部， 1粘贴
     * @param currentCount
     * @param selectCount
     * @param action
     * @param step
     * @return
     */
    public int step(int tag, int currentCount, int selectCount, int action, int step){
        if(tag == currentCount) return step;
        if(selectCount > tag || currentCount > tag) return -1;
        int s1 = -1;
        int s2 = -1;
        if(action == 0){
            if(currentCount != selectCount){
                s1 = step(tag, currentCount, currentCount,0,step+1);
            }
            s2 = step(tag, currentCount, currentCount,1,step+1);

        } else {
            s1 = step(tag, currentCount+selectCount, selectCount,0,step+1);
            s2 = step(tag, currentCount+selectCount, selectCount,1,step+1);
        }

        if(s1 == -1 && s2 == -1){
            return -1;
        } else if(s1 == -1){
            return s2;
        } else if(s2 == -1){
            return s1;
        }
        return Math.min(s1,s2);

    }

}
