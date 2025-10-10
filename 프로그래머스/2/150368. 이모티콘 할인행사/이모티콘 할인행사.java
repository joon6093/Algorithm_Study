import java.util.*;

class Solution {
    
    static int[] discountRate = {10, 20, 30, 40};
    static int[] applyDiscountRate;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        applyDiscountRate = new int[emoticons.length];
        dfs(0, users, emoticons);
        
        return answer;
    }
    
    void dfs(int index, int[][] users, int[] emoticons) {
        if (index == emoticons.length) {
            int plusCount = 0;
            int priceSum = 0;
            for (int j = 0; j<users.length; j++) {
                int personSum = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (discountRate[applyDiscountRate[i]] < users[j][0]) {
                        continue;
                    }
                    int price = emoticons[i];
                    int discountPrice = (price * (100 - discountRate[applyDiscountRate[i]])) / 100;
                    personSum += discountPrice;
                    priceSum += discountPrice;
                }
                if (personSum >= users[j][1]) {
                    plusCount++;
                    priceSum-=personSum;
                }
            }
            int plusAnswerCount = answer[0];
            int priceAnswerSum = answer[1];
            if (plusAnswerCount < plusCount) {
                answer[0] = plusCount;
                answer[1] = priceSum;
            } else if (plusAnswerCount == plusCount) {
                if (priceAnswerSum < priceSum) {
                    answer[0] = plusCount;
                    answer[1] = priceSum;
                }
            }
        }
        
        for (int i =index; i < emoticons.length; i++) {
            for (int j = 0; j< 4; j++) {
                applyDiscountRate[i] = j;
                dfs(i+1, users, emoticons);
            }
        }
    
    }
}   