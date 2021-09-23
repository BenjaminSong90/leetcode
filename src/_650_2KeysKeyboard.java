import java.util.HashMap;
import java.util.Map;

public class _650_2KeysKeyboard {

    public static void main(String[] args) {
        System.out.println("result>>>>" + new _650_2KeysKeyboard().minSteps(1));
    }

    public int minSteps(int n) {
        return step(n, 1, 0, 0);
    }

    /**
     * @param tag
     * @param currentCount
     * @param selectCount
     * @param step
     * @return
     */
    public int step(int tag, int currentCount, int selectCount, int step) {
        if (tag == currentCount) return step;
        if (selectCount > tag || currentCount > tag) return -1;
        int s1 = -1;
        int s2 = -1;

        if (currentCount != selectCount) {
            s1 = step(tag, currentCount, currentCount, step + 1);
        }

        if (selectCount != 0)
            s2 = step(tag, currentCount + selectCount, selectCount, step + 1);

        if (s1 == -1 && s2 == -1) {
            return -1;
        } else if (s1 == -1) {
            return s2;
        } else if (s2 == -1) {
            return s1;
        }
        return Math.min(s1, s2);

    }

}
