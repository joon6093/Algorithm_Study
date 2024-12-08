import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }

                Character c = stack.pop();
                if (c != '(') {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}