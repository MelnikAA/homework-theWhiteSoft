import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int clamp(int min, int max, int value){
        return Math.max(min, Math.min(max, value));
    }

    public static void main(String[] args) {
        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        List<String> book = new ArrayList<>();
        String[] words = input.trim().split("\\s+");
        StringBuilder line = new StringBuilder();
        int sumLine = 0;
        for (String word : words) {
            if ((sumLine + word.length() > 36)) {
                book.add(line.toString());
                sumLine = 0;
                line = new StringBuilder();

            }
            line.append(word);
            line.append(" ");
            sumLine = (sumLine + word.length());
            sumLine++;

        }

        int now = 0;
        int rows = 10;
        int rowCount = book.size();
        int border = clamp(0, rowCount, now + rows);
        for (int row = now; row < border; ++row) {
            System.out.println(book.get(row));
        }

        now = border;
        while (true) {

            String abc = in.nextLine();
            System.out.println();
            switch (abc) {
                case "d" -> {
                    border = clamp(0, rowCount, now + rows);
                    for (int row = now; row < border; ++row) {
                        System.out.println(book.get(row));
                    }
                    now = border;
                }
                case "a" -> {
                    border = clamp(0, rowCount, now - rows);
                    for (int row = border; row < now; ++row) {
                        System.out.println(book.get(row));
                    }
                    now = border;
                }
            }
        }

    }
}
