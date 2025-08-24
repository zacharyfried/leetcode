import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class LC239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> window = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();

        if (nums.length <= k){
            for (int num : nums){
                maxList.add(num);

            }
            int max = Collections.max(maxList);
            return new int[]{max};
        }

        int l = 0;
        int r = k - 1;

        // Initial loading
        for (int i = 0; i < r; i++){
            window.add(nums[i]);
        }

        while (r < nums.length){
            window.add(nums[r]);
            maxList.add(Collections.max(window));
            window.remove(0);
            r++;
        }

        int[] res = new int[maxList.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = maxList.get(i);
        }
        return res;
    }

    public static void main(String[] args){
        LC239_SlidingWindowMaximum obj = new LC239_SlidingWindowMaximum();
        int[] nums = new int[]{1,2,1,0,4,2,6};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}
