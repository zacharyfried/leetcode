public class LC33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;

            if (nums[l] < nums[m]){ // min can't be to the left of mid and not at l
                if (target > nums[m] || target < nums[l]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else { // min can't be to the right of mid
                if (target < nums[m] || target > nums[r]){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }


        }

        return -1;
    }
}
