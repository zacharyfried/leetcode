import java.util.*;

public class LC153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]){
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];

    }

    public static void main(String[] args){
        LC153_FindMinimuminRotatedSortedArray obj = new LC153_FindMinimuminRotatedSortedArray();

        System.out.println(obj.findMin(new int[]{3,4,5,1,2}));
    }
}
