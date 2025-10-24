package required;

import java.util.Scanner;

public class Required {

    Scanner sc = new Scanner(System.in);

    public int requiredNumber(String text) {
        System.out.println(text);
        int a = sc.nextInt();
        sc.nextLine();
        return a;
    }

    public String requiredText(String text) {
        System.out.println(text);
        return sc.nextLine();
    }

    public void systemOutPrint(String text) {
        System.out.println(text);
    }
}
