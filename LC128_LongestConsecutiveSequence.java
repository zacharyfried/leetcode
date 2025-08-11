import java.util.ArrayList;

public class LC128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }

        ArrayList<Integer> sortedNums = new ArrayList<>();
        for (int num : nums){
            sortedNums.add(num);
        }

        sortedNums.sort((a, b) -> a - b);

        ArrayList<Integer> longest = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        current.add(sortedNums.getFirst());
        sortedNums.removeFirst();

        for (Integer num : sortedNums){
            if (num == current.getLast() + 1){
                current.add(num);
                if (current.size() >= longest.size()){
                    longest = current;
                }
            } else if (num.equals(current.getLast())) {
                continue;
            } else {
                current = new ArrayList<>();
                current.add(num);
            }
        }

        if (current.size() >= longest.size()){
            longest = current;
        }

        return longest.size();
    }
}
