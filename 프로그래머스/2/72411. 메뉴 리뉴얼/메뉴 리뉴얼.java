import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        String[] sortOrders = new String[orders.length];
        for(int i = 0; i<orders.length; i++) {
            String order = orders[i];
            String[] arr = order.split("");
            Arrays.sort(arr);
            sortOrders[i] = String.join("", arr);
        }
        
        for(int count : course) {
            map.clear();
            
            for (int i =0; i<orders.length; i++) {
                String order = sortOrders[i];
                if (order.length() < count) {
                    continue;
                }
                dfs(order, "", 0, count);
            }
            
            Set<String> keySet= map.keySet();
            List<String> keyList = new ArrayList<>(keySet);
            int max = 0;
            for(int i =0; i<keyList.size(); i++) {
                max = Math.max(max, map.get(keyList.get(i)));
            }
            if (max < 2) {
                continue;
            }
            
            for(int i =0; i<keyList.size(); i++) {
                if (map.get(keyList.get(i)) == max) {
                    answerList.add(keyList.get(i));
                }
            } 
        }
        
        Collections.sort(answerList);
        
        return answerList;
    }
    
    private void dfs(String order, String current, int index, int count) {
        if (current.length() == count) {
            if (!map.containsKey(current)) {
                map.put(current, 1);
                return;
            }
            map.put(current, map.get(current) + 1);
            return;
        }
        
        for(int i = index; i<order.length(); i++) {
            current+= String.valueOf(order.charAt(i));
            dfs(order, current, i+1, count);
            current = current.substring(0, current.length() -1);
        }
    }
}