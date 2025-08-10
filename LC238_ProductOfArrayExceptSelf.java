public class LC238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        int[] res = new int[nums.length];
        res[0] = rightProduct[0];
        res[nums.length-1] = leftProduct[nums.length-1];

        if(nums.length==1){
            return res;
        }

        for (int i = 1; i < nums.length - 1; i++){
            res[i] = leftProduct[i] * rightProduct[i];
        }
        return res;
    }
}
