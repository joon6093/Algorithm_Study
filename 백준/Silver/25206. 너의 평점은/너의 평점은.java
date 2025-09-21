import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr1 = new int[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = 20;
        double totalScore = 0;
        double totalGrade = 0;

        while (line-- > 0) {
            String[] input = br.readLine().split(" ");
            double score = Double.parseDouble(input[1]);
            String grade = input[2];

            if (grade.equals("P")) {
                continue;
            }

            double result = getScore(grade, score);
            totalScore += result;
            totalGrade += score;
        }

        System.out.printf("%.6f", totalScore / totalGrade);
    }

    private static double getScore(
        String grade,
        double score
    ) {
        switch (grade) {
            case "A+":
                return score * 4.5;
            case "A0":
                return score * 4.0;
            case "B+":
                return score * 3.5;
            case "B0":
                return score * 3.0;
            case "C+":
                return score * 2.5;
            case "C0":
                return score * 2.0;
            case "D+":
                return score * 1.5;
            case "D0":
                return score * 1.0;
            case "F":
                return 0;
            default:
                return 0;
        }
    }
}
