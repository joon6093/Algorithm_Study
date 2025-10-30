import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
        }
        double one = (double) sum / N; 
        if (String.format("%.0f", one).equals("-0")) {
            System.out.println(0);
        } else {
            System.out.println(String.format("%.0f", one));
        }
        
        
        int[] temp = arr.clone();
        Arrays.sort(temp);
        System.out.println(temp[N/2]);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for(int i =0; i<list.size(); i++) {
            int current = map.get(list.get(i));
            if (current > count) {
                count = current;
            }
        }

        List<Integer> three = new ArrayList<>();
        for(int i =0; i<list.size(); i++) {
            int current = map.get(list.get(i));
            if (current == count) {
                three.add(list.get(i));
            }
        }
        
        if (three.size() > 1) {
            Collections.sort(three);
            System.out.println(three.get(1));
        } else {
            System.out.println(three.get(0));
        }

        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        } 

        System.out.println(max - min);
    }
}
