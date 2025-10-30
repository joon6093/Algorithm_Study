import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        String[] arr = new String[N];
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        for(int i =0; i<N; i++) {
            arr[i] = br.readLine();
        }

        Set<Character> keys = new HashSet<>();
        for(int i=0; i<N; i++) {
            String words = arr[i];
            String[] word = words.split(" ");
            boolean flag = false;
            int index = 0;
            for(int j=0; j<word.length; j++) {
                char c = Character.toLowerCase(word[j].charAt(0));
                if(!keys.contains(c)) {
                    keys.add(c);
                    answer[i] = index;
                    flag = true;
                    break;
                }
                index+=word[j].length() + 1;
            }  
            
            if (flag) {
                continue;
            }

            for(int j=0; j<words.length(); j++) {
                char c = Character.toLowerCase(words.charAt(j));
                if (c == ' ') {
                    continue;
                }
                if(!keys.contains(c)) {
                    keys.add(c);
                    answer[i] = j;
                    flag = true;
                    break;
                }
            }
        }

        for(int i =0; i<N; i++) {
            for(int j=0; j<arr[i].length(); j++) {
                if (j == answer[i]) {
                    System.out.print("[");
                } 
                System.out.print(arr[i].charAt(j));
                if (j == answer[i]) {
                    System.out.print("]");
                } 
            }
            System.out.println();
        }
    }
}
