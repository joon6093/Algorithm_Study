import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        String[] input2 = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(input2[i]);
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
            numbers.add(number);
            index.add(number);
        }

        Collections.sort(numbers, (o1, o2) -> {
            int freq1 = frequencyMap.get(o1);
            int freq2 = frequencyMap.get(o2);
            if (freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            } else {
                return Integer.compare(index.indexOf(o1), index.indexOf(o2));
            }
        });

        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number).append(" ");
        }
        System.out.println(result);
    }
}
