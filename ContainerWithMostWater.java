public class ContainerWithMostWater {
    public static void main(String[] a) {
        int[] data = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(data));
    }

    public int maxArea(int[] height) {
        int area = 0;
        int endIndex = height.length -1;
        int startIndex = 0;
        while (startIndex<endIndex){
            int a = Math.min(height[startIndex],height[endIndex]) * (endIndex-startIndex);
            area = Math.max(a, area);

            if(height[startIndex]>height[endIndex]){
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return area;
    }
}
