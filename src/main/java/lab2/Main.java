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

        printTask();
        int stop = 0;
        // если переменная равна нулю, то программа выполняется
        // while - это цикл
        while(stop == 0) {

            System.out.println("Введите строку:");
            // вводим строку с клавы
            String input = scanner.nextLine();

            checkInputString(input);

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

    /**
     * Проверяет, является ли введенная строка шестнадцатеричным цветом и выводит результат на экран
     * @param input - введенная строка
     */
    private static void checkInputString(String input) {
        // если строка соответствует регулярному выражению, то сообщаем об этом
        if(Pattern.matches(REGEX, input)) {
            System.out.println("Строка " + input + " является шестнадцатеричным цветом");
        } else {
            System.out.println("Строка " + input + " не является шестнадцатеричным цветом");
        }
    }

    private static void printTask() {
        System.out.println("Лабораторная 2");
        System.out.println("Задание: Написать регулярное выражение, определяющее является ли данная\n" +
                "строчка шестнадцатеричным идентификатором цвета в HTML. Где\n" +
                "#FFFFFF для белого, #000000 для черного, #FF0000 для красного и т.д");
        System.out.println("- пример правильных выражений: #FFFFFF, #FF3421, #00ff00.\n" +
                "- пример неправильных выражений: 232323, f#fddee, #fd2.");
        System.out.println("Задание выполнили: Басманова, Прошина");
        System.out.println();
    }

}