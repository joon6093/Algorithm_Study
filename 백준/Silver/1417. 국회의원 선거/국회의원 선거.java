import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> peoples = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            peoples.add(Integer.parseInt(br.readLine()));
        }

        while (true) {
            int maxPeople = Collections.max(peoples);
            int maxPeopleCount = Collections.frequency(peoples, maxPeople);

            if (maxPeople == peoples.get(0) && maxPeopleCount == 1) {
                break;
            }

            for (int i = 1; i < n; i++) {
                if (peoples.get(i) == maxPeople) {
                    peoples.set(i, peoples.get(i) - 1);
                    peoples.set(0, peoples.get(0) + 1);
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
