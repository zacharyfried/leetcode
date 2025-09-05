import java.util.*;

public class LC153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {

        int a = 0;
        int b = nums.length - 1;
        int c = 0;

        while(Math.abs(a-b) > 1){
            c = (a + b) / 2;
            if (nums[a] < nums[c] && nums[c] < nums[b]){
                b = c;
            } else if (nums[a] > nums[c] && nums[c] < nums[b]){
                b = c;
            } else {
                a = c;
            }
        }

        return Math.min(nums[a], nums[b]);
    }
}
