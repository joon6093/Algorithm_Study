class Solution {
    public String solution(String video_lenString, String posString, String op_startString, String op_endString, String[] commands) {
        int video_len = calculateTime(video_lenString);
        int pos = calculateTime(posString);
        int op_start = calculateTime(op_startString);
        int op_end = calculateTime(op_endString);
        
        
        if (pos >= op_start && pos <= op_end) {
            pos = op_end;
        }
        for(int i=0; i<commands.length; i++) {
            String command = commands[i];
            
            if (command.equals("prev")) {
                pos -= 10;
                if (pos < 0) {
                    pos = 0;
                }
            } else if (command.equals("next")) {
                pos += 10;
                if (pos > video_len) {
                    pos = video_len;
                }
            }
            
            if (pos >= op_start && pos <= op_end) {
                pos = op_end;
            }
        }
        
        String answer = calculateTime(pos);
        return answer;
    }
    
    private int calculateTime(String time) {
        String[] times = time.split(":");
        int m = Integer.parseInt(times[0]);
        int s = Integer.parseInt(times[1]);
        
        return m * 60 + s;
    }
    
    private String calculateTime(int time) {
        String m = toString(String.valueOf(time / 60));
        String s = toString(String.valueOf(time % 60));
        
        return m+":"+s;
    }
    
    private String toString(String time) {
        if (time.length() == 1) {
            return "0" + time;
        } 
        
        return time;
    }
}