import java.util.HashSet;

public class LC424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxCount = 0;
        int res = 0;
        int l = 0;
        int[] freq = new int[26];

        for (int r = 0; r < s.length(); r++){
            int index = s.charAt(r) - 'A';
            freq[index]++;
            maxCount = Math.max(maxCount, freq[index]);

            while ((r - l + 1) - maxCount > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, (r - l + 1));
        }

        return res;
    }
}
