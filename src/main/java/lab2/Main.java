package lab2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    // регулярное выражение
    // в нем символ ^ обозначает, что мы ищем это выражение только с начала строки
    // символ # входит в состав цвета (#FFF000, #00ff00 и т.д.)
    // в квадратных скобках указывается, какие символы идут после #
    // A-Fa-f0-9 показывает, что после # могут идти буквы от A до F, либо от a до f, либо число от 0 до 9
    // в фигурных скобках указывается, сколько раз должно попасться выражение в квадратных скобках
    // знак $ указывает, что если выражение встретилось, то после него строка должна закончиться
    private static final String REGEX = "^#[A-Fa-f0-9]{6}$";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int stop = 0;
        // если переменная равна нулю, то программа выполняется
        // while - это цикл
        while(stop == 0) {

            System.out.println("Введите строку:");
            // вводим строку с клавы
            String input = scanner.nextLine();

            // если строка соответствует регулярному выражению, то сообщаем об этом
            if(Pattern.matches(REGEX, input)) {
                System.out.println("Строка " + input + " является шестнадцатеричным цветом");
            } else {
                System.out.println("Строка " + input + " не является шестнадцатеричным цветом");
            }
            System.out.println();
            System.out.println("Введите 0, чтобы выполнить программу еще раз");
            System.out.println("Введите любой другой символ, чтобы завершить программу");
            if(scanner.hasNextInt()) {
                stop = scanner.nextInt();
                scanner.nextLine();
            } else {
                // если введено не целое число, то задаем значение stop отличное от нуля, чтобы программа завершилась
                stop = 1;
            }

        }

    }

}
