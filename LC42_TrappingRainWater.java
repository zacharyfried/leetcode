import java.util.*;

public class LC42_TrappingRainWater {
    public int trap(int[] height) {
        int totalVol = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < height.length - 1; i++){
            if (height[i] == 0 || height[i] < height[i + 1]) continue;
            for (int j = i + 1; j < height.length; j ++){
                if (height[i] > height[j]){
                    continue;
                } else {
                    map.put(i, j);
                    System.out.println("Putting " + i + " and " + j);
                    i = j - 1;
                    break;
                }
            }
        }

        for (int i = height.length - 1; i >= 1; i--){
            if (height[i] == 0 || height[i] < height[i - 1]) continue;
            for (int j = i - 1; j > 0; j--){
                if (height[i] > height[j]){
                    continue;
                } else {
                    map.put(j, i);
                    System.out.println("Putting " + j + " and " + i);
                    i = j + 1;
                    break;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int shorterHeight = Math.min(height[entry.getKey()], height[entry.getValue()]);
            int width = entry.getValue() - entry.getKey() - 1;
            int maxVol = shorterHeight * width;
            for (int i = entry.getKey() + 1; i < entry.getValue(); i++){
                maxVol -= height[i];
            }
            System.out.println(maxVol);
            totalVol += maxVol;
        }
        return totalVol;
    }

    public static void main(String[] args){
        LC42_TrappingRainWater obj = new LC42_TrappingRainWater();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }
}
