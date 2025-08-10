import java.util.*;

public class LC347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int[] couple = {entry.getValue(), entry.getKey()};
            arr.add(couple);
        }


        arr.sort((a,b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++){
            result[i] = arr.removeFirst()[1];
        }

        return result;
    }

    public static void main(String[] args){
        LC347_TopKFrequentElements obj = new LC347_TopKFrequentElements();

        int[] nums = {1,2};
        int[] result = obj.topKFrequent(nums, 2);
        System.out.println(result);

    }
}
