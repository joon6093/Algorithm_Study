import java.util.*;

class Solution {
    
    class Task { 
        public String name;
        public int start;
        public int remain;
    }
    
    public List<String> solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();
        for(int i=0; i<plans.length; i++) {
            Task task = new Task();
            task.name = plans[i][0];
            task.start = calTime(plans[i][1]);
            task.remain = Integer.parseInt(plans[i][2]);
            
            tasks.add(task);
        }
        
        Collections.sort(tasks, (o1, o2) -> {
            return o1.start - o2.start;
        });
        
        List<String> answer = new ArrayList<>();
        Deque<Task> deque = new ArrayDeque<>();
        for(int i=0; i<tasks.size(); i++) {
            if(i == tasks.size()-1) {
                answer.add(tasks.get(i).name);
                while(!deque.isEmpty()) {
                    Task task = deque.pollLast();
                    answer.add(task.name);
                }
            } else {
                int current = tasks.get(i).start;
                int next = tasks.get(i+1).start;
                int result = next-current;
                if(result >= tasks.get(i).remain) {
                    answer.add(tasks.get(i).name);
                    int nextTurn = result - tasks.get(i).remain;
                    while(!deque.isEmpty()) {
                        Task task = deque.pollLast();
                        if(nextTurn >= task.remain) {
                            nextTurn-=task.remain;
                            answer.add(task.name);
                        } else {
                            task.remain -= nextTurn;
                            deque.add(task);
                            break;
                        }
                    }
                } else {
                    tasks.get(i).remain -= result;
                    deque.add(tasks.get(i));
                }  
            }
        }
        
        return answer;
    }
    
    private int calTime(String time) {
        String[] times = time.split(":");
        
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}