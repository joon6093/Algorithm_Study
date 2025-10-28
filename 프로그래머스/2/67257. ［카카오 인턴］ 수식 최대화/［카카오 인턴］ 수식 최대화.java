import java.util.*;

class Solution {
    
    long answer = 0;
    char[] ops = {'+', '-', '*'};
    boolean[] opUse;
    char[] visited;
    List<Long> numbers;
    List<Character> opers;

    public long solution(String expression) {
        numbers = new ArrayList<>();
        opers = new ArrayList<>();
        visited = new char[3];
        opUse = new boolean[3];
        String temp = "";
        for (int i =0; i<expression.length(); i++) {
            if (expression.charAt(i) == '+' || 
                expression.charAt(i) == '-' || 
                expression.charAt(i) == '*') {
                numbers.add(Long.valueOf(temp));
                opers.add(expression.charAt(i));
                temp = "";
            } else {
                temp += String.valueOf(expression.charAt(i));
            }
        }
        numbers.add(Long.valueOf(temp));
        
        for (int i = 0; i<numbers.size(); i++) {
            // System.out.println(numbers.get(i));
        }
        
        for (int i = 0; i<opers.size(); i++) {
            // System.out.println(opers.get(i));
        }
        
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int index) {
        if (index == 3) {
            List<Long> numbersTemp = new ArrayList<>(numbers);
            List<Character> opersTemp = new ArrayList<>(opers);
            for (int i =0; i<3; i++) {
                char op = visited[i];
                // System.out.println(op);
                for(int j =0; j<opersTemp.size();) {
                    if (opersTemp.get(j).equals(op)) {
                        // System.out.println(op);
                        long result = cal(numbersTemp.get(j), numbersTemp.get(j+1), opersTemp.get(j));
                        numbersTemp.remove(j);
                        numbersTemp.remove(j);
                        numbersTemp.add(j, result);
                        opersTemp.remove(j);
                    } else {
                        j++;
                    }
                }
            }
            // System.out.println(numbersTemp.get(0));
            answer = Math.max(answer, Math.abs(numbersTemp.get(0)));
            return;
        }
        
        for (int i = 0; i< 3; i++) {
            if (opUse[i]) {
                continue;
            }
            visited[index] = ops[i];
            opUse[i] = true;
            dfs(index+1);
            opUse[i] = false;
        }
    }
    
    private long cal(long num1, long num2, char op) {
        if (op == '+') {
            return num1 + num2;
        }
        
         if (op == '-') {
            return num1 - num2;
        }
        
         if (op == '*') {
            return num1 * num2;
        }
        
        return 0;
    }
}