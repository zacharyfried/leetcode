import java.util.Stack;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            res[i] = 0;
            int j = i + 1;
            while(j < temperatures.length && temperatures[i]>temperatures[j]){
                j++;
            }
            res[i] = j == temperatures.length ? 0 : j - i;
        }


        return res;
    }
}
