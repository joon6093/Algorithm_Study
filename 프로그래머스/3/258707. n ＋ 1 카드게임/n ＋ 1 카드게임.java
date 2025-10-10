import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int startDraw = cards.length / 3;
        int need = cards.length + 1;
        Deque<Integer> cardDeque = new ArrayDeque<>();
        for(int i=0; i<cards.length; i++) {
            cardDeque.add(cards[i]);
        }
        Set<Integer> hand = new HashSet<>();
        for(int i =0; i<startDraw; i++ ) {
            hand.add(cardDeque.pollFirst());
        }
        Set<Integer> pool = new HashSet<>();
        
        while(!cardDeque.isEmpty()) {
            pool.add(cardDeque.pollFirst());
            pool.add(cardDeque.pollFirst());
            
            if(handCanPlay(hand, need)) {
                answer++;
                continue;
            }
            if (coin >= 1) {
                if(poolHandCanPlay(hand, pool, need)) {
                    coin--;
                    answer++;
                    continue;
                }
            }
            if (coin >= 2) {
                if(poolCanPlay(pool, need)) {
                    coin--;
                    coin--;
                    answer++;
                    continue;
                }
            }
            
            break;
        }   
        
        return answer;
    }
    
    boolean handCanPlay(Set<Integer> hand, int need) {
        for (Integer num : new HashSet<>(hand)) {
            int turnNeed = need - num;
            if (hand.contains(turnNeed)) {
                hand.remove(num);
                hand.remove(turnNeed);
                return true;
            }
        }
        return false;
    }   
    
    boolean poolHandCanPlay(Set<Integer> hand, Set<Integer> pool, int need) {
        for (Integer num : new HashSet<>(hand)) {
            int turnNeed = need - num;
            if (pool.contains(turnNeed)) {
                hand.remove(num);
                pool.remove(turnNeed);
                return true;
            }
        }
        return false;
    }   
    
    boolean poolCanPlay(Set<Integer> pool, int need) {
        for (Integer num : new HashSet<>(pool)) {
            int turnNeed = need - num;
            if (pool.contains(turnNeed)) {
                pool.remove(num);
                pool.remove(turnNeed);
                return true;
            }
        }
        return false;
    }   
}