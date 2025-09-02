import java.util.Stack;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>(); // [temp, index]

        for (int i = 0; i < temperatures.length; i++){
            int t = temperatures[i];

            while (!stack.isEmpty() && t > stack.peek()[0]){
                // Save pair to variable so we can access index
                int[] pair = stack.pop();

                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});

        }
        return res;
    }
}
