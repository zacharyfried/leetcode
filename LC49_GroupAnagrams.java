import java.util.*;

public class LC49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();


        HashMap<HashMap<Character, Integer>, ArrayList<String>> maps = new HashMap<>();

        for (int i = 0; i < strs.length; i++){
            String s = strs[i];
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }

            maps.computeIfAbsent(map, k -> new ArrayList<>()).add(s);
        }

        maps.forEach((key, value) -> {
            result.add(value);
        });


        return result;
    }
}
