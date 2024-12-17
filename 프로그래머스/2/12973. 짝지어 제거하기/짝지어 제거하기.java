import java.util.ArrayDeque;
import java.util.Deque;

class Solution
{
    public int solution(String s)
    {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(String.valueOf(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        if (stack.isEmpty()) {
            return 1;
        } 
        return 0;
    }
}