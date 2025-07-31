import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            List<Character> stringSet = skill.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

            String skillTree = skill_trees[i];
            for (int j = 0; j < skillTree.length(); j++) {
                char c = skillTree.charAt(j);
                if (stringSet.isEmpty()) {
                    answer++;
                    break;
                }
                if (stringSet.get(0) == c) {
                    stringSet.remove(Character.valueOf(c));
                } else if (stringSet.subList(1, stringSet.size()).contains(c)) {
                    break;
                }

                if (j == skillTree.length() - 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
