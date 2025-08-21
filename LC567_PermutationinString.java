import java.util.Arrays;

public class LC567_PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : s1.toCharArray()){
            arr1[c - 'a']++;
        }

        int l = 0;

        for (int r = 0; r < s2.length(); r++){
            arr2[s2.charAt(r) - 'a']++;

            if (r < s1.length() - 1){
                continue;
            } else if (Arrays.equals(arr1, arr2)){
                return true;
            } else {
                arr2[s2.charAt(l) - 'a']--;
                l++;
            }

        }

        return false;
    }
}
