import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] arr = new int[friends.length][friends.length];
        List<String> friendList = Arrays.asList(friends);
        for (int i = 0; i<gifts.length; i++) {
            String[] input = gifts[i].split(" ");
            String A = input[0];
            String B = input[1];
            
            arr[friendList.indexOf(A)][friendList.indexOf(B)]++;
        }
        
        int[] point = new int[friends.length];
        for (int i = 0; i<friends.length; i++) {
             for (int j =0; j<friends.length; j++) {
                 point[i] += arr[i][j];
                 point[i] -= arr[j][i];
             }
        }
        
        for (int i = 0; i<friends.length; i++) {
            int temp = 0;
            for (int j =0; j<friends.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][j] == arr[j][i]) {
                    if (point[i] > point[j]){
                        temp++;
                    }
                }else if (arr[i][j] > arr[j][i]) {
                    temp++;
                }
            }
            answer = Math.max(answer, temp);
        } 
            
        return answer;
    }
}