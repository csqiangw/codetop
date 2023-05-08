import java.util.Stack;

public class _14_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty())
                    return false;
                c = stack.pop();
                if((c == '(' && s.charAt(i) != ')') || (c == '[' && s.charAt(i) != ']') || (c == '{' && s.charAt(i) != '}')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
