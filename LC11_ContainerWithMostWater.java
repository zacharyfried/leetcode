public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r){
            int shorterHeight = height[l] < height[r] ? height[l] : height[r];
            int curr = shorterHeight * (r - l);
            if (curr > max){
                max = curr;
            }

            if (height[l] < height[r]){
                int lastL = height[l];
                while (l < r && height[l] <= lastL){
                    l++;
                }
            } else {
                int lastR = height[r];
                while (l < r && height[r] <= lastR){
                    r--;
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
