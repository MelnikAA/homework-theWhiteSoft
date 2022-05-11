import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int clamp(int min, int max, int value) {
        return Math.max(min, Math.min(max, value));
    }

    public static int printPageUp(int currentRow, int rows, List<String> book) {
        int toRow = clamp(0, book.size(), currentRow + rows);
        for (int row = currentRow; row < toRow; ++row) {
            System.out.println(book.get(row));
        }
        return currentRow;
    }

    public static int printPageDown(int currentRow, int rows, List<String> book) {
        int toRow = clamp(0, book.size(), currentRow - rows);
        for (int row = toRow; row < currentRow; ++row) {
            System.out.println(book.get(row));
        }
        return currentRow;
    }


    public static void main(String[] args) {

        final int maxLength = 36;
        final int rowsInPage = 10;

        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        List<String> book = new ArrayList<>();

        String[] words = input.trim().split("\\s+");
        StringBuilder line = new StringBuilder();

        int sumLine = 0;
        for (String word : words) {
            if ((sumLine + word.length() > maxLength)) {
                book.add(line.toString());
                sumLine = 0;
                line = new StringBuilder();
            }
            line.append(word);
            line.append(" ");
            sumLine = (sumLine + word.length());
            sumLine++;

        }

        int now = printPageUp(0, rowsInPage, book);
        while (true) {
            input = in.nextLine();
            System.out.println();
            switch (input) {
                case "d" -> {
                    now = printPageUp(now, rowsInPage, book);
                }
                case "a" -> {
                    now = printPageDown(now, rowsInPage, book);
                }
            }
        }

    }
}
