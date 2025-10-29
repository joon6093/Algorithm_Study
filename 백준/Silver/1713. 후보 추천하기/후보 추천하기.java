import java.io.*;
import java.util.*;

class Main {

    static class Student {

        public int index;
        public int count;
        public int time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        List<Student> list = new ArrayList<>();
        Student[] arr = new Student[101];
        for (int i =0; i<M; i++) {
            int studentIndex = Integer.parseInt(inputs[i]);

            if (arr[studentIndex] != null) {
                arr[studentIndex].count++;
            } else {
                if (list.size() < N){
                    Student current = new Student();
                    current.index = studentIndex;
                    current.count = 1;
                    current.time = i;

                    arr[studentIndex]= current;
                    list.add(current);
                } else {
                    Collections.sort(list, (o1, o2) -> {
                        if (o1.count == o2.count) {
                            return o2.time - o1.time;
                        }

                        return o2.count - o1.count;
                    });
                    
                    Student remove = list.remove(N-1);
                    arr[remove.index] = null;
                    

                    Student current = new Student();
                    current.index = studentIndex;
                    current.count = 1;
                    current.time = i;

                    arr[studentIndex]= current;
                    list.add(current);
                }
            }
        }

          Collections.sort(list, (o1, o2) -> {
                return o1.index - o2.index;
            });

        for (int i =0; i<list.size(); i++) {
            System.out.print(list.get(i).index + " ");
        }
    }
}
