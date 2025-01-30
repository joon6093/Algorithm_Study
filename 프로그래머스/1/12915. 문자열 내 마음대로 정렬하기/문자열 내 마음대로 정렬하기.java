import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();

        for (String string : strings) {
            list.add(string.charAt(n) + string);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }
}