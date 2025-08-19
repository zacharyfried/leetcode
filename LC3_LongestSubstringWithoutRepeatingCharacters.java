import java.util.HashSet;

public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int l = 0;
        int r = 0;

        HashSet<Character> set = new HashSet<>();

        while (r < s.length()){
            if (!set.add(s.charAt(r))){
                // We are trying to add a character that already exists
                maxLength = Math.max(maxLength, s.substring(l, r).length());
                // We need to remove chars from the set from l to whichever index that char is at
                char c = s.charAt(r);
                int cIndex = l + s.substring(l, r).indexOf(c);
                for (int i = l; i < cIndex; i++){
                    set.remove(s.charAt(i));
                }
                l = cIndex + 1;
            }
            r++;
        }


        return Math.max(maxLength, s.substring(l, r).length());
    }

    public static void main(String[] args){
        LC3_LongestSubstringWithoutRepeatingCharacters obj = new LC3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("gaaqfeqlqky"));
    }
}
