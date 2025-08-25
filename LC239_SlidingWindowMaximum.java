import java.util.*;

public class LC239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> que = new LinkedList<>();
        int l = 0;
        int r = 0;

        while (r < nums.length){
            // Remove from the back (right side) of the deque anything
            // smaller than what we are about to add since this isn't
            // useful to compare going forward
            while(!que.isEmpty() && nums[que.getLast()] < nums[r]){
                que.removeLast();
            }

            // Add index r to back of deque (right side)
            que.addLast(r);

            // Since the values in the que are indices, and in
            // increasing recentness as one goes to the right,
            // if the left most index (the one about to leave
            // the window as we shift it) is still in the deque,
            // remove it
            if (l > que.getFirst()){
                que.remove();
            }

            // If we have incremented r enough that we are at window size,
            // we need to shift the window instead of just adding r
            if ((r + 1) >= k){
                // The front of the deque is going to be the largest
                // nums[l[ value, since more recent larger vals pop
                // everything and they become left most, or if they
                // are smaller they just get added to the right
                output[l] = nums[que.getFirst()];
                l++;
            }

            r++;
        }

        return output;




    }

    public static void main(String[] args){
        LC239_SlidingWindowMaximum obj = new LC239_SlidingWindowMaximum();
        int[] nums = new int[]{1,2,1,0,4,2,6};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}
