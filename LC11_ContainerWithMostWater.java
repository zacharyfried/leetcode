public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length - 1; i++){
            int j;
            if (height[i] == 0){
                continue;
            } else {
                j = (max / height[i]);
            }

            for (j = j; j < height.length; j++){
                int distance = j - i;
                int shorterHeight = height[i] < height[j] ? height[i] : height[j];
                int currVol = distance * shorterHeight;
                if (max < currVol) {
                    max = currVol;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        LC11_ContainerWithMostWater obj = new LC11_ContainerWithMostWater();
        int max = obj.maxArea(height);
        System.out.println(max);
    }
}
