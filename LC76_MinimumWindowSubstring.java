import java.util.HashMap;
import java.util.Map;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String res = "";

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int l = 0;

        for (int r = 0; r < s.length(); r++){
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            while (containsT(sMap, tMap)){
                if (res.length() == 0){
                    res = s.substring(l, r + 1);
                } else if (res.length() > (r - l + 1)) {
                    res = s.substring(l, r + 1);
                }
                sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                l++;
            }
        }


        return res;
    }

    private static boolean containsT(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap){
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()){
            if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";

        LC76_MinimumWindowSubstring obj = new LC76_MinimumWindowSubstring();
        System.out.println(obj.minWindow(s, t));
    }
}
