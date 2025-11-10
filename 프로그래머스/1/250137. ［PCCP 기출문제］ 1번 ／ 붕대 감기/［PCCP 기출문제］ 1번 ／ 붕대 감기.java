class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int sequence = 0;
        int prev = 1;
        int current = health;
        for(int i=0; i<attacks.length; i++) {
            int index = attacks[i][0];
            int damage = attacks[i][1];
            for (int j=prev; j<index; j++) {
                sequence ++;
                current += bandage[1];
                
                if(sequence == bandage[0]) {
                    current += bandage[2];
                    sequence = 0;
                }
                 
                if (current > health) {
                    current = health;
                } 
            }
            current -= damage;
            sequence = 0;
            
            if (current <= 0) {
                break;
            }
            prev = index+1;
        }
        
        answer = current;
        if (current <= 0) {
            answer = -1;
        }
        return answer;
    }
}