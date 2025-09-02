import java.util.*;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else if (!stack.empty()) {
                char cs = stack.pop();

                if (c == ')' &&  cs == '('){
                    continue;
                } else if (c == ']' && cs == '[') {
                    continue;
                } else if (c == '}' && cs == '{') {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }


        }
        if (!stack.empty()){
            return false;
        }

        return true;

    }

    public static void main(String[] args){
        LC20_ValidParentheses obj = new LC20_ValidParentheses();
        System.out.println(obj.isValid("()"));
    }
}
