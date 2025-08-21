import java.util.HashSet;

public class LC424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int res = 0;

        HashSet<Character> chars = new HashSet<>();

        for (char c : s.toCharArray()){
            chars.add(c);
        }

        for (char c : chars){
            int count = 0;
            int l = 0;

            for (int r = 0; r < s.length(); r++){
                if (s.charAt(r) == c){
                    count++;
                }

                // Window size minus count (of non-changed chars)
                // is essentially the number of changes chars
                // So like while we have to many changes chars, we move l
                while ((r - l + 1) - count > k){
                    if (s.charAt(l) == c){
                        count--; // we have one less unchanged char in window
                    }
                    l++;
                }
                res = Math.max(res, (r - l + 1));
            }

        }
        return res;
    }
}
