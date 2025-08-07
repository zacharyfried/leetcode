import java.util.*;

public class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                array[0] = i;
                array[1] = map.get(diff);
                return array;
            }
            map.put(nums[i], i);
        }
        return array;
    }

    public static void main(String[] args){
        int [] nums = {2,7,11,15};
        LC1_TwoSum obj = new LC1_TwoSum();
        System.out.println(Arrays.toString(obj.twoSum(nums, 9)));
    }
}
