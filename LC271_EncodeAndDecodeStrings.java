import java.util.*;

public class LC271_EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();


        for (String s : strs){
            if (s.isEmpty()) {
                sb.append("BLANK");

            } else {
                sb.append(s);
            }
            sb.append("!@!@!@%");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();

        String[] arr = s.split("!@!@!@%");

        for (String str : arr){
            if (str.equals("BLANK")){
                list.add("");
            } else {
                list.add(str);
            }
        }

        if (list.isEmpty()) list.add("");

        return list;
    }
}
