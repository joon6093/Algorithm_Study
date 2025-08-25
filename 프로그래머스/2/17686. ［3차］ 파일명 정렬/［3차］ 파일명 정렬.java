import java.util.Arrays;

class Solution {

    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] part1 = splitFileName(f1);
            String[] part2 = splitFileName(f2);

            int headCompare = part1[0].toLowerCase().compareTo(part2[0].toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }

            int num1 = Integer.parseInt(part1[1]);
            int num2 = Integer.parseInt(part2[1]);
            return Integer.compare(num1, num2);
        });

        return files;
    }

    private static String[] splitFileName(String file) {
        int i = 0;
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            i++;
        }
        String head = file.substring(0, i);

        int j = i;
        while (j < file.length() && Character.isDigit(file.charAt(j))) {
            j++;
        }
        String number = file.substring(i, j);

        return new String[]{head, number};
    }
}
