import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        List<String> qweqwe = new ArrayList<>();
        String[] aa = a.trim().split("\\s+");
        StringBuilder b = new StringBuilder();
        int s = 0;
        for (String i : aa) {
            if ((s + i.length() <= 36)) {
                b.append(i);
                b.append(" ");
                s = (s + i.length());
                s++;
            }
            else {
                qweqwe.add(b.toString());s = 0;
                b = new StringBuilder();

                b.append(i);
                b.append(" ");
                s = (s + i.length());
                s++;
            }

        }

        int temp = 0;
        int r = 10;
        int rm = qweqwe.size();
        for (int i = temp; (i < Math.max(0, Math.min(rm, (temp + r)))); i++) {
            System.out.println(qweqwe.get(i));
        }

        temp = Math.max(0, Math.min(rm, (temp + r)));
        while (true) {

            String abc = in.nextLine();
            System.out.println();
            switch (abc) {
                case "d":
                    System.out.flush();
                    for (int i = temp; (i < Math.max(0, Math.min(rm, (temp + r)))); i++) {
                        System.out.println(qweqwe.get(i));
                    }

                    temp = Math.max(0, Math.min(rm, (temp + r)));
                    break;
                case "a":

                    for (int i = Math.max(0, Math.min(rm, (temp - r))); (i < temp); i++) {
                        System.out.println(qweqwe.get(i));
                    }

                    temp = Math.max(0, Math.min(rm, (temp - r)));
                    break;
            }
        }

    }
}
