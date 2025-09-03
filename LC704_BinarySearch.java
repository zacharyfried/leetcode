public class LC704_BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int middle = (start + end) / 2;
            if (target > nums[middle]){
                start = middle + 1;
            } else if (target < nums[middle]){
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
