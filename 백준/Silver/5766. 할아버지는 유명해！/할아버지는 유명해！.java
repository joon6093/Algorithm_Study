import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
                String[] inputs = br.readLine().split(" ");
                int N = Integer.parseInt(inputs[0]);
                int M = Integer.parseInt(inputs[1]);
                if (N == 0 && M == 0){
                        break;
                }
                Map<Integer, Integer> map = new HashMap<>();
                
                for (int i = 0; i<N; i++) {
                        String[] temp = br.readLine().split(" ");
                        for (int j=0; j<M; j++) {
                                Integer number = Integer.parseInt(temp[j]);
                                if (!map.containsKey(number)) {
                                        map.put(number, 1);
                                        continue;
                                } 
                                map.put(number, map.get(number) + 1);
                        }
                }
                
                List<Integer> list = new ArrayList<>(map.keySet());
                Collections.sort(list , (o1, o2) -> {
                       return map.get(o2) - map.get(o1);
                });

                List<Integer> answer = new ArrayList<>();
                answer.add(list.get(1));
                for (int i= 2; i<list.size(); i++) {
                        if (map.get(list.get(1)) == map.get(list.get(i))) {
                                answer.add(list.get(i));
                        } else {
                                break;
                        }
                        
                }

                Collections.sort(answer);
                for (int i =0; i <answer.size(); i++) {
                        System.out.print(answer.get(i) + " ");
                }
                System.out.println();
        }
    }
}
