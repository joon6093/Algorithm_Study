import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Deque<Integer> q1 = new ArrayDeque();
        Long q1Sum = 0L;
        Deque<Integer> q2 = new ArrayDeque();
        Long q2Sum = 0L;
        for (int i = 0; i < queue1.length; i++) {
            q1.addLast(queue1[i]);
            q1Sum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.addLast(queue2[i]);
              q2Sum += queue2[i];
        }
        if ((q1Sum + q2Sum) % 2 != 0) {
            return -1;
        }
        Long goal = (q1Sum + q2Sum) / 2;
        
        while(true) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            
            if (q1Sum > q2Sum) {
                int temp = q1.pollFirst();
                q1Sum -= temp;
                q2.addLast(temp);
                q2Sum += temp;
                answer++;
            } else if (q1Sum < q2Sum) {
                int temp = q2.pollFirst();
                q2Sum -= temp;
                q1.addLast(temp);
                q1Sum += temp;
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}