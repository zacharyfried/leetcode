import java.util.*;

public class LC981_TimeBasedKeyValueStoreArray {
    class TimeMap {

        HashMap<String, List<Pair<Integer, String>>> store;

        public TimeMap() {
            store = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Pair<Integer, String>> values = store.getOrDefault(key, new ArrayList<>());
            int l = 0;
            int r = values.size() - 1;
            String res = "";

            while (l <= r){
                int m = (l + r) / 2;
                if (values.get(m).getKey() <= timestamp){
                    res = values.get(m).getValue();
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return res;
        }
    }

    public class Pair<K, V>{

        public final K key;
        public final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


}
