import java.util.*;

class Solution {

    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, new HashSet<>());
        return result.size();
    }

    private void dfs(String[] user_id, String[] banned_id, int idx, Set<String> selected) {
        if(idx == banned_id.length) {
            result.add(new HashSet<>(selected)); // 깊은 복사
            return;
        }

        for(int i = 0; i < user_id.length; i++) {
            if(selected.contains(user_id[i])) continue;
            if(isMatch(user_id[i], banned_id[idx])) {
                selected.add(user_id[i]);

                dfs(user_id, banned_id, idx + 1, selected);

                selected.remove(user_id[i]);
            }
        }
    }

    private boolean isMatch(String user, String ban) {
        if(user.length() != ban.length()) return false;
        for(int i = 0; i < user.length(); i++) {
            if(ban.charAt(i) == '*') continue;
            if(user.charAt(i) != ban.charAt(i)) return false;
        }
        return true;
    }
}
