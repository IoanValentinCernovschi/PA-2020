package app;

import com.*;
import java.util.Scanner;

public class LocaleExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scrieti una din comenzile: info, display locales, set locale sau exit");
        String command = scanner.nextLine();
        while(!command.equals("exit")) {
            if(command.equals("info")) {
                Info.getLocaleInfo();
            }
            else {
                if(command.equals("display locales")) {
                    DisplayLocales.displayLocales();
                }
                else {
                    if(command.equals("set locale")) {
                        System.out.println("Specificati limba si tara: ");
                        SetLocale.setLocale(scanner.nextLine(), scanner.nextLine());
                    }
                }
            }
            System.out.println("Scrieti una din comenzile: info, display locales, set locale sau exit");
            command = scanner.nextLine();
        }
    }
}
