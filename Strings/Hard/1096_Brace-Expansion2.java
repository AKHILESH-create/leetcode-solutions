import java.util.*;

class Solution {

    private String expression;
    private int idx;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.idx = 0;

        Set<String> result = expr();
        return new ArrayList<>(result);
    }

    // item -> letter | { expr }
    private Set<String> item() {
        Set<String> ret = new TreeSet<>();

        if (idx < expression.length() && expression.charAt(idx) == '{') {
            idx++; // move past '{'
            ret = expr();
            if (idx < expression.length() && expression.charAt(idx) == '}') {
                idx++; // move past '}'
            }
            return ret;
        }

        if (idx < expression.length()) {
            ret.add(String.valueOf(expression.charAt(idx)));
            idx++;
        }
        return ret;
    }

    // term -> item | item term
    private Set<String> term() {
        Set<String> ret = new TreeSet<>(Collections.singleton(""));

        while (idx < expression.length()) {
            char ch = expression.charAt(idx);
            if (ch != '{' && !Character.isLetter(ch)) {
                break;
            }

            Set<String> sub = item();
            Set<String> tmp = new TreeSet<>();
            for (String left : ret) {
                for (String right : sub) {
                    tmp.add(left + right);
                }
            }
            ret = tmp;
        }

        return ret;
    }

    // expr -> term | term, expr
    private Set<String> expr() {
        Set<String> ret = new TreeSet<>();

        while (idx < expression.length()) {
            ret.addAll(term());

            if (idx < expression.length() && expression.charAt(idx) == ',') {
                idx++; // move past ','
                continue;
            }

            if (idx < expression.length() && expression.charAt(idx) == '}') {
                break;
            }

            break;
        }

        return ret;
    }
}
