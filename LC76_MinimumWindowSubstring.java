import java.util.*;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) return "";

        // Frequency of chars in t
        int[] need = new int[128];
        int required = 0; // number of unique chars in t
        for (char c : t.toCharArray()){
            if (need[c] == 0){
                required++; // indicate a new distinct char
            }
            need[c]++; // increase frequency of this char
        }

        int[] have = new int[128]; // freq array for window
        int formed = 0; // tracks all chars where we have all needed

        int l = 0;
        int bestL = 0; // l pointer for best window
        int bestLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++){
            char cr = s.charAt(r);
            have[cr]++;

            // Update formed if we have all of this char
            if (need[cr] > 0 && have[cr] == need[cr]){
                formed++;
            }

            // Shrink while valid (if valid at all)
            while (formed == required){
                int winLen = r - l + 1;
                if (winLen < bestLen){
                    bestLen = winLen;
                    bestL = l;
                }

                char cl = s.charAt(l);
                have[cl]--;
                // If removal of this char messes up validity formed = req
                if (need[cl] > 0 && have[cl] < need[cl]){
                    formed--;
                }
                l++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }


}
