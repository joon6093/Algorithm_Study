import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] point = new int[8];
        int temp = -3;
        for (int i =1; i < point.length; i++) {
            point[i] = temp;
            temp++;
        }
        
        int[] answer = new int[4];
        for (int i = 0; i<choices.length; i++) {
            String serveyTemp = survey[i];
            int takePoint = point[choices[i]];
            if (serveyTemp.equals("RT")) {
                answer[0] += takePoint;
            } else if (serveyTemp.equals("TR")) {
                answer[0] -= takePoint;
            } else if (serveyTemp.equals("CF")) {
                answer[1] += takePoint;
            } else if (serveyTemp.equals("FC")) {
                answer[1] -= takePoint;
            } else if (serveyTemp.equals("JM")) {
                answer[2] += takePoint;
            } else if (serveyTemp.equals("MJ")) {
                answer[2] -= takePoint;
            } else if (serveyTemp.equals("AN")) {
                answer[3] += takePoint;
            } else if (serveyTemp.equals("NA")) {
                answer[3] -= takePoint;
            } 
        }
        
        StringBuilder answerString = new StringBuilder();
        if (answer[0] > 0) {
            answerString.append("T");
        } else if (answer[0] < 0) {
            answerString.append("R");
        } else {
            answerString.append("R");
        }
        
        if (answer[1] > 0) {
            answerString.append("F");
        } else if (answer[1] < 0) {
            answerString.append("C");
        } else {
            answerString.append("C");
        }
        
        if (answer[2] > 0) {
            answerString.append("M");
        } else if (answer[2] < 0) {
            answerString.append("J");
        } else {
            answerString.append("J");
        }
        
        if (answer[3] > 0) {
            answerString.append("N");
        } else if (answer[3] < 0) {
            answerString.append("A");
        } else {
            answerString.append("A");
        }
        
        return answerString.toString();
    }
}