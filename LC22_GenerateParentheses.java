import java.util.*;

public class LC22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, stack, res);
        return res;
    }

    private void backtrack(int openN, int closedN, int n, StringBuilder stack, List<String> res){
        if (closedN == openN && openN == n){
            // Since all needed parentheses have been added, add to result list
            res.add(stack.toString());
            return;
        }

        if (openN < n){
            stack.append('(');
            backtrack(openN + 1, closedN, n, stack, res);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN){
            stack.append(')');
            backtrack(openN, closedN + 1, n, stack, res);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
